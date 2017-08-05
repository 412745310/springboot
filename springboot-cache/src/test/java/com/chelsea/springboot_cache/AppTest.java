package com.chelsea.springboot_cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chelsea.springboot_cache.service.CacheService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	CacheService cacheService;

	@Test
	public void getCacheString() {
		String result = cacheService.getCacheString();
		System.out.println(result);
	}

}
