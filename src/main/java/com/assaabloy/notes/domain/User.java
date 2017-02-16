package com.assaabloy.notes.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int userId;
    private String userName;

    public User() {

    }

    public User(int userId, String userName) {
        this.userName = userName;
        this.userId = userId;
    }

    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonProperty
    public String getUserName() {
        return userName;
    }

    @JsonProperty
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
