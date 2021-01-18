package com.apiit.model;

import com.apiit.dto.ProductDetailsDto;

import java.util.List;

public class AppUser {

    private String username;

    private String userId;

    private String userType;

    private List<ProductDetailsDto> products;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
