package com.zl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-21
 */

public class DistributeLockUtil {
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String requestIdKey = "request_key";
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(60);
        jedisPoolConfig.setMaxWaitMillis(200);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 1000);
    }

    public boolean doLock(String key, String requestId, int expireTime) {
        SetParams setParams = new SetParams();
        setParams.nx().ex(expireTime);
        Jedis jedis = jedisPool.getResource();
        try {
            String result = jedis.set(key, requestId, setParams);
            return LOCK_SUCCESS.equals(result);
        } catch ( Exception e ) {

        } finally {
            jedis.close();
        }
        return false;

    }

    public boolean unLock(String key, String requestId) {
        Jedis jedis = jedisPool.getResource();
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        return RELEASE_SUCCESS == jedis.eval(script, 1, key, requestId);
    }


    public long getRequestId(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.incr(requestIdKey);
    }
}

