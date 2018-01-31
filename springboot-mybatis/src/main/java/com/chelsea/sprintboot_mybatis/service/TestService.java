package com.chelsea.sprintboot_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chelsea.sprintboot_mybatis.bean.Test;
import com.chelsea.sprintboot_mybatis.dao.TestDao;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public List<Test> queryTest() {
        return testDao.queryTest();
    }


    
    public void insertTest() {
        insert();
    }

    @Transactional()
    public void insert() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                throw new RuntimeException();
            }
            Test test = new Test();
            test.setName("name" + i);
            test.setScore(100 + i);
            testDao.insert(test);
        }
    }

}
