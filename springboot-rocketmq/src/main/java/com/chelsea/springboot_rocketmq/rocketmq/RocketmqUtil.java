package com.chelsea.springboot_rocketmq.rocketmq;

import javax.annotation.PostConstruct;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息工具类
 * 
 * @author shevchenko
 *
 */
@Component
public class RocketmqUtil {

	@Value("${mq.nameserver}")
	private String mqNameserver;

	final DefaultMQProducer producer = new DefaultMQProducer(
			"ProducerGroupName");

	@PostConstruct
	public void init() {
		try {
			producer.setNamesrvAddr(mqNameserver);
			producer.setInstanceName("Producer");
			producer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public SendResult sendMsg(Message message) throws Exception {
		SendResult sendResult = producer.send(message);
		return sendResult;
	}

}
