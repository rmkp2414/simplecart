package com.apiit.api;

import java.io.Serializable;

public class LoginResponse implements Serializable {


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String userId;
    private String email;
    private String username;
    private boolean success;


}
