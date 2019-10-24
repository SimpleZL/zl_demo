package com.zl.redis;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * redis实现延迟队列
 *
 * @author: liangzhang212928
 * @Date: 2019-07-22
 */
public class DelayQueueUtil {

    @Autowired
    Jedis jedis;

    public boolean addMeta(String key, long score, String member) {
        return jedis.zadd(key, score, member) > 0;
    }

    /**
     * @param key
     * @param score 当前时间戳-延迟时间量
     * @return
     */
    public String getMeta(String key, long score) {
        String member = "";
        Set<String> members = jedis.zrangeByScore(key, score, score, 0, 1);
        if (CollectionUtils.isNotEmpty(members)) {
            String tmpResult = members.iterator().next();
            //支持多线程
            if (jedis.zrem(key, tmpResult) > 0) {
                member = tmpResult;
            }

        }
        return member;
    }
}
