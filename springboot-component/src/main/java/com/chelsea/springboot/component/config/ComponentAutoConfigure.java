package com.chelsea.springboot.component.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chelsea.springboot.component.service.ComponentService;

@Configuration
@EnableConfigurationProperties(ComponentServiceProperties.class)
public class ComponentAutoConfigure {
    
    @Autowired
    private ComponentServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service",value = "enabled",havingValue = "true")
    public ComponentService exampleService (){
        return  new ComponentService(properties.getPrefix(),properties.getSuffix());
    }

}
