package com.chelsea.springboot_first_application.service;

import org.springframework.stereotype.Component;

@Component
public abstract class PService {
    
    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public abstract void test();
    
    

}
