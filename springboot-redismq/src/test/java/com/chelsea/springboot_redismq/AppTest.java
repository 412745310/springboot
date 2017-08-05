package com.chelsea.springboot_redismq;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	Logger logger = LoggerFactory.getLogger(AppTest.class);

	@Autowired
	StringRedisTemplate template;

	@Autowired
	CountDownLatch latch;

	@Test
	public void senMessage() throws InterruptedException {
		logger.info("Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");
		latch.await();
		System.exit(0);
	}

}
