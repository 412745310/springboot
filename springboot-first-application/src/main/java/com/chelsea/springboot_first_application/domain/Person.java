package com.chelsea.springboot_first_application.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    
    private String name;
    private List<Integer> hobby = new ArrayList<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Integer> getHobby() {
        return hobby;
    }
    public void setHobby(List<Integer> hobby) {
        this.hobby = hobby;
    }
    
}
