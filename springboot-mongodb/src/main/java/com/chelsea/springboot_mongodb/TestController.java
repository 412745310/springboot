package com.chelsea.springboot_mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot_mongodb.bean.Test;
import com.chelsea.springboot_mongodb.dao.TestDao;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestDao testDao;

	@RequestMapping("/find")
	@ResponseBody
	public List<Test> find() {
		return testDao.findAll();
	}
	
	@RequestMapping("/save")
	public void save(String name, Integer age) {
		Test test = new Test();
		test.setName(name);
		test.setAge(age);
		testDao.save(test);
	}

}
