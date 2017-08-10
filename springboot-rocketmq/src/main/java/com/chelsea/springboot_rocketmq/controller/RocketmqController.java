package com.chelsea.springboot_rocketmq.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chelsea.springboot_rocketmq.rocketmq.RocketmqUtil;

@Controller
@RequestMapping("/rocketmq")
public class RocketmqController {

	@Autowired
	private RocketmqUtil rocketmqUtil;

	@Value("${log.path}")
	private String logPath;

	@Value("${mq.topic}")
	private String mqTopic;

	@Value("${mq.tags}")
	private String mqTags;

	@Value("${mq.keys}")
	private String mqKeys;

	@RequestMapping("/producemsg")
	public String produceMsg() {
		BufferedReader bf = null;
		try {
			File file = new File(logPath);
			bf = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = bf.readLine()) != null) {
				Message message = new Message();
				message.setTopic(mqTopic);
				message.setTags(mqTags);
				message.setKeys(mqKeys);
				message.setBody(line.getBytes());
				rocketmqUtil.sendMsg(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "mq消息初始化成功";
	}
}
