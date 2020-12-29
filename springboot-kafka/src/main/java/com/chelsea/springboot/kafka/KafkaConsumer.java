package com.chelsea.springboot.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者
 * 
 * @author shevchenko
 *
 */
@Component
public class KafkaConsumer {

    /**
     * 监听批量消费
     * 
     * @param records
     */
    @KafkaListener(topics = "covid19", containerFactory = "batchFactory")
    public void listen(List<ConsumerRecord<String, String>> records) {
        records.forEach(record -> consumer(record));
    }

    /**
     * 监听单条消费
     */
    //@KafkaListener(topics = {"testlog"})
    public void listen2(ConsumerRecord<String, String> record) {
        consumer(record);
    }

    public void consumer(ConsumerRecord<String, String> record) {
        System.out.println("主题: " + record.topic() + ", 内容: " + record.value());
    }

}
