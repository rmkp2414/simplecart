package com.apiit.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    @SerializedName("id")
    private String userId;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;
    @SerializedName("jwt")
    private  String jwtToken;

   // private String imageURL;

    @SerializedName("userType")
    private String userType;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName(";")
    private String lastName;
    @SerializedName("country")
    private String country;
    @SerializedName("addressLine1")
    private String addressLine1;
    @SerializedName("addressLine2")
    private String addressLine2;
    @SerializedName("zipCode")
    private String zipCode;
    @SerializedName("city")
    private String city;
    @SerializedName("province")
    private String province;
    @SerializedName("phoneNumber")
    private String phoneNumber;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUserId() {
        return userId;
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
}
