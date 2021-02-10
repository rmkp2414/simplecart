package com.apiit.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private static final long serialVersionUID = 6539700350037792600L;

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("firstName")
    private String firstname;
    @SerializedName("lastName")
    private String lastname;
    @SerializedName("userType")
    private String userType;
    @SerializedName("phoneNumber")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("addressLine1")
    private String address1;
    @SerializedName("addressLine2")
    private String address2;
    @SerializedName("city")
    private String state;
    @SerializedName("zipCode")
    private String zip;
    @SerializedName("country")
    private String country;

    public User(int id, String username, String firstname, String lastname,  String userType, String phone, String email, String address1, String address2,  String state, String zip, String country) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
