package com.chelsea.springboot_cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@SuppressWarnings("static-access")
	@Cacheable("cache")
	public String getCacheString() {
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "cacheString";
	}

}
