package com.chelsea.springboot.kafka;

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

    @KafkaListener(topics = {"testTopic"})
    public void receive(String message) throws InterruptedException {
        System.out.println("app_log--消费消息:" + message);
        Thread.sleep(10000);
    }

}
