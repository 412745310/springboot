package com.chelsea.springboot_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	JedisCluster jedisCluster;

	@RequestMapping("/set/{key}/{value}")
	public String set(@PathVariable("key") String key,
			@PathVariable("value") String value) {
		return jedisCluster.set(key, value);
	}

	@RequestMapping("/get/{key}")
	public String get(@PathVariable("key") String key) {
		return jedisCluster.get(key);
	}

}
