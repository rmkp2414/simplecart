package com.apiit.model;

import com.apiit.model.Cart;

import java.util.List;

public class ShippingOrder {

    private String username;
    private String fullname;
    private String addressline;
    private String country;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;

    private List<Cart> userCart;

    public List<Cart> getUserCart() {
        return userCart;
    }

    public void setUserCart(List<Cart> userCart) {
        this.userCart = userCart;
    }

    public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddressline() {
            return addressline;
        }

        public void setAddressline(String addressline) {
            this.addressline = addressline;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) { this.state = state; }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


