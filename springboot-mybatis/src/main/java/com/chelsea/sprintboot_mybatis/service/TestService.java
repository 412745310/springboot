package com.chelsea.sprintboot_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chelsea.sprintboot_mybatis.bean.Test;
import com.chelsea.sprintboot_mybatis.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao testDao;

	public List<Test> queryTest() {
		return testDao.queryTest();
	}

}
