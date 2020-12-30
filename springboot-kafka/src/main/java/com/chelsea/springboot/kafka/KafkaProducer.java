package com.chelsea.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * kafka生产者
 * 
 * @author shevchenko
 *
 */
@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<?, String> kafkaTemplate;

    /**
     * 定时任务
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void send() throws Exception {
        int i = 0;
        while (true) {
            String message = "aaa_" + (i++);
            ListenableFuture<?> future = kafkaTemplate.send("testTopic", message);
            future.addCallback(o -> System.out.println("send-消息发送成功：" + message),
                    throwable -> System.out.println("消息发送失败：" + message));
            Thread.sleep(1000);
        }
    }

}
