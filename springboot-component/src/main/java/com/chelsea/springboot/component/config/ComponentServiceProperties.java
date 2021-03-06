package com.chelsea.springboot.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example.service")
public class ComponentServiceProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }



}
