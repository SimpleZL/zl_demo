package com.zl.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-01
 */
public class HelloKafka_Producer {
    public static void main(String[] args) {
        //配置参数
        Properties properties = initConfig();
        // 构造生产者客户端

        //构造消息体
        ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstantst.TOPIC, "hello,kafka!");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties);) {
            producer.send(record, (recordMetadata, e) -> System.out.println("发送完成"));
        } catch ( Exception e ) {
            //关闭流
//            producer.close();
        }

    }

    /**
     * 生产者配置相关
     *
     * @return
     */
    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstantst.kafkaBrokerlist);
        //对于处理可重发异常，配置重试次数  -默认值为0
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        return properties;
    }
}
