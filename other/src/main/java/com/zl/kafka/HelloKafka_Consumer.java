package com.zl.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-01
 */
public class HelloKafka_Consumer {
    public static final String GROUP_ID = "hello_kafka_group";

    public static Properties initProperties() {
        Properties properties = new Properties();
        //此处和生产者配置刚好相反  序列化&反序列话 必须配置 没有默认值
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstantst.kafkaBrokerlist);
        //默认消费起始
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, System.getProperty("server_ip"));
        //指定位移消费-earliest ,latest,none
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initProperties();
        //创建消费者客户端
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        //订阅主题
        kafkaConsumer.subscribe(Collections.singletonList(KafkaConstantst.TOPIC));
        Set<TopicPartition> assignment = new HashSet<>();
        while (assignment.size() == 0) {
            kafkaConsumer.poll(Duration.ofMillis(1000));
            //为消费者分配分区
            assignment = kafkaConsumer.assignment();
        }
        //获取每个分区的最新消费位置
        Map<TopicPartition, Long> offets = kafkaConsumer.endOffsets(assignment);
        for (TopicPartition tp : assignment) {
            kafkaConsumer.seek(tp, offets.get(tp));
        }
        //循环消费消息
        while (true) {
            // 会从当前分配的分区中拉取消息
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.toString());
            }
        }
    }
}
