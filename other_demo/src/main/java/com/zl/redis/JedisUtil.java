package com.zl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-01-22
 */
public class JedisUtil {
    public static JedisPool jedisPool;
    public static Jedis jedis;

    static {
        //m.y.redis.sohucs.com:22071:be3f892ce38be40b276b84affbb97f44
        String SRS_HOST = "m.y.redis.sohucs.com";
        int SRS_PORT = 22071;
        int connectionTimeout = 500;
        String pwd = "be3f892ce38be40b276b84affbb97f44";
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(60);
        jedisPool = new JedisPool(jedisPoolConfig, SRS_HOST, SRS_PORT, connectionTimeout, pwd);
    }

    public static long lpush(String key, String... values) {
        long value = -1;
        try {
            jedis = jedisPool.getResource();
            value = jedis.lpush(key, values);
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        } finally {
            jedis.close();
        }
        return value;
    }

    public static String rpop(String key) {
        String value = "";
        try {
            jedis = jedisPool.getResource();
            value = jedis.rpop(key);
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        } finally {
            jedis.close();
        }
        return value;
    }



    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
