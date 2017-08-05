package com.chelsea.springboot_cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot_cache.service.CacheService;

@RestController
public class CacheController {

	@Autowired
	CacheService service;

	@RequestMapping("get-cache-sting")
	public String getCacheString() {
		return service.getCacheString();
	}

}
