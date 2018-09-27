package com.chelsea.springboot_properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot_properties.bean.ConfigBean;
import com.chelsea.springboot_properties.bean.User;
import com.chelsea.springboot_properties.service.HelloService;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class HelloController {

    @Autowired
    ConfigBean configBean;

    @Autowired
    User user;

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid() + " >>>>"
                + configBean.getMax() + ">>>>" + configBean.getNumber();
    }

    @RequestMapping("/user")
    public String user() {
        return user.getName() + user.getAge();
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return helloService.sayHello();
    }
}
