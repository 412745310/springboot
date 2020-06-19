package com.chelsea.sprintboot_mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.sprintboot_mybatis.bean.PageRequest;
import com.chelsea.sprintboot_mybatis.bean.PageResult;
import com.chelsea.sprintboot_mybatis.bean.Test;
import com.chelsea.sprintboot_mybatis.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/query-test")
    @ResponseBody
    public List<Test> queryTest() {
        return testService.queryTest();
    }

    @RequestMapping("/insert-test")
    public void insertTest() {
        testService.insertTest();
    }
    
    /**
     * 分页查询
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectPage")
    public PageResult selectPage(PageRequest pageRequest) {
        return testService.selectPage(pageRequest);
    }
    
    @RequestMapping("/insert-test-batch")
    public List<Long> insertTestBatch() {
        return testService.insertTestBatch();
    }

}
