package com.chelsea.springboot.multidb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot.multidb.domain.UserEntity;
import com.chelsea.springboot.multidb.mapper.test1.User1Mapper;
import com.chelsea.springboot.multidb.mapper.test2.User2Mapper;
import com.chelsea.springboot.multidb.mapper.test3.User3Mapper;

@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private User3Mapper user3Mapper;

    @RequestMapping("/getUser1")
    public List<UserEntity> getUser1() {
        List<UserEntity> users = user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/getUser2")
    public List<UserEntity> getUser2(Long id) {
        List<UserEntity> users = user2Mapper.getAll();
        return users;
    }

    @RequestMapping("/getUser3")
    public List<UserEntity> getUser3(Long id) {
        List<UserEntity> users = user3Mapper.getAll();
        return users;
    }

}
