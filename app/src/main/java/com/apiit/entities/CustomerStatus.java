package com.apiit.entities;

public class CustomerStatus {
    private Integer id;
    private Customer customer;
    private boolean activeStatus;

    public CustomerStatus() {
    }

    @Override
    public String toString() {
        return "CustomerStatus{" +
                "id=" + id +
                ", customer=" + customer +
                ", activeStatus=" + activeStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
