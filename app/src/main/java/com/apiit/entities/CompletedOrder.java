package com.apiit.entities;

import java.util.List;

public class CompletedOrder {
    private Integer Id;
    private Integer cartID;
    private Integer customerId;
    private Integer productItemId;
    private double price;
    private int Quantity;
    private double total;
    private List<SoldItem>soldItems;

    public CompletedOrder() {
    }

    @Override
    public String toString() {
        return "CompletedOrder{" +
                "Id=" + Id +
                ", cartID=" + cartID +
                ", customerId=" + customerId +
                ", productItemId=" + productItemId +
                ", price=" + price +
                ", Quantity=" + Quantity +
                ", total=" + total +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(Integer productItemId) {
        this.productItemId = productItemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
