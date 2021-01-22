package com.apiit.model;



import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    private static final long serialVersionUID = 6539700350037792600L;

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("userId")
    private String userId;
    @SerializedName("name")
    private String name;
    @SerializedName("userType")
    private String userType;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private String address;
    @SerializedName("state")
    private String state;
    @SerializedName("zip")
    private String zip;

    public User(int id, String username, String userId, String name, String userType, String phone, String email, String address, String state, String zip) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
