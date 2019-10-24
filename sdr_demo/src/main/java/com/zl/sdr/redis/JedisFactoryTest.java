package com.zl.sdr.redis;

import com.zl.sdr.config.SpringConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-01-29
 */
public class JedisFactoryTest {
    /**
     * xml配置
     * ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
     * JedisConnectionFactory jedisFactory = context.getBean("jedisConnectionFactory", JedisConnectionFactory.class);
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConf.class);
        JedisConnection connection = (JedisConnection) applicationContext.getBean("jedisConnectionFactory", JedisConnectionFactory.class).getConnection();
//        String testKey = "archetype";
//        connection.stringCommands().set(testKey.getBytes(), "123".getBytes());
//        System.out.println(new String(connection.stringCommands().get(testKey.getBytes())));
        StringRedisTemplate redisTemplate = applicationContext.getBean("redisTemplate", StringRedisTemplate.class);
        //获取list操作对象
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        redisTemplate.boundListOps("redisTemplate").leftPush("redis nb a ");
        System.out.println(redisTemplate.boundListOps("redisTemplate").leftPop());
    }
}




