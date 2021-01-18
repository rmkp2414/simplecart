package com.apiit.entities;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String shippingAdressL1;
    private String ShippingAdressL2;
    private String zipCode;
    private String contactNo;
    private User user;
    private CustomerStatus customerStatus;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", shippingAdressL1='" + shippingAdressL1 + '\'' +
                ", getShippingAdressL2='" + ShippingAdressL2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShippingAdressL1() {
        return shippingAdressL1;
    }

    public void setShippingAdressL1(String shippingAdressL1) {
        this.shippingAdressL1 = shippingAdressL1;
    }

    public String getShippingAdressL2() {
        return ShippingAdressL2;
    }

    public void setShippingAdressL2(String ShippingAdressL2) {
        this.ShippingAdressL2 = ShippingAdressL2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }
}
