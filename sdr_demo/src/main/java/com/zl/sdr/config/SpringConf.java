package com.zl.sdr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-01-29
 */
@Configuration
public class SpringConf {
    @Bean
    public JedisPoolConfig initJedisPool() {
        return null;
    }

    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory initJedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("ma.y.redis.sohucs.com");
        redisStandaloneConfiguration.setPort(22083);
        redisStandaloneConfiguration.setPassword(RedisPassword.of("e3b890687bb7fbd28bb547e1b9f215db"));
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        return jedisConnectionFactory;
    }

//    @Bean(name = "jedisSentinelConnectionFactory")
//    public JedisConnectionFactory initJedisSentinelConnectionFactory() {
//        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
//        redisSentinelConfiguration.master("master1").sentinel("sa.y.redis.sohucs.com", 25083);
//        return new JedisConnectionFactory(redisSentinelConfiguration);
//    }

    @Bean(name = "redisTemplate")
    public StringRedisTemplate initRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }


}
