package com.chelsea.springboot.multidb.domain;

public class UserEntity {

    private Long id;

    private String username;

    public UserEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
