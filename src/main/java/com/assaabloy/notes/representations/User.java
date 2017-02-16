package com.assaabloy.notes.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jersey.params.LongParam;

public class User {

    private LongParam userId;
    private String userName;

    public User() {

    }

    public User(LongParam userId, String userName) {
        this.userName = userName;
        this.userId = userId;
    }

    @JsonProperty
    public LongParam getUserId() {
        return userId;
    }

    @JsonProperty
    public void setUserId(LongParam userId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        return userName != null ? userName.equals(user.userName) : user.userName == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
