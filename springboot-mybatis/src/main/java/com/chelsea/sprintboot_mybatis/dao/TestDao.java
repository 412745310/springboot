package com.chelsea.sprintboot_mybatis.dao;

import java.util.List;

import com.chelsea.sprintboot_mybatis.bean.Test;

public interface TestDao {

	List<Test> queryTest();
	
	void insert(Test test);

}
