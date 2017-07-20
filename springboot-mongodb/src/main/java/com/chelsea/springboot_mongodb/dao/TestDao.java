package com.chelsea.springboot_mongodb.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chelsea.springboot_mongodb.bean.Test;

public interface TestDao extends MongoRepository<Test, Serializable>{

}
