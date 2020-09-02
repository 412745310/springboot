package com.chelsea.springboot_first_application.service;

import org.springframework.stereotype.Service;

@Service("AService")
public class AService extends PService {
    
    @Override
    public void test() {
        System.out.println(getServiceName());
    }

}
