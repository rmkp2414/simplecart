package com.apiit.model;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("addressLine1")
    private String addressline;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("email")
    private String email;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("password")
    private String password;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("province")
    private String state;
    @SerializedName("username")
    private String username;
    @SerializedName("userType")
    private String userType;
    @SerializedName("zipCode")
    private String zipCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddressline(String addressline) {
        this.addressline = addressline;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) { this.state = state; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
