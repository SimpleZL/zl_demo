package com.zl.format;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-25
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        try (Jedis jedis = jedisPool.getResource()) {
            System.out.println(jedis.hget("key", "vale"));
        }
    }
}
