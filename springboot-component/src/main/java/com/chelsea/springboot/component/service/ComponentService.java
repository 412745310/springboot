package com.chelsea.springboot.component.service;

public class ComponentService {

    private String prefix;
    private String suffix;

    public ComponentService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String wrap(String word) {
        return prefix + word + suffix;
    }

}
