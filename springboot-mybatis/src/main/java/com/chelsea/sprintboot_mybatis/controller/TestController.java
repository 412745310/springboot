package com.chelsea.sprintboot_mybatis.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.sprintboot_mybatis.bean.Test;
import com.chelsea.sprintboot_mybatis.service.TestService;

@RestController
@RequestMapping("/test")
@MapperScan("com.chelsea.sprintboot_mybatis.dao")
public class TestController {

	@Autowired
	TestService testService;

	@RequestMapping("/query-test")
	@ResponseBody
	public List<Test> queryTest() {
		return testService.queryTest();
	}

}
