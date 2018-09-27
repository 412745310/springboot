package com.chelsea.springboot_properties.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import com.chelsea.springboot_properties.service.HelloService;

public class CustomConfig {

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        HelloService service = new HelloService();
        return service;
    }
}
