package com.apiit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cart {

    @SerializedName("cartId")
    private int cartId;
    @SerializedName("totalAmount")
    private double totalAmount;
    @SerializedName("userId")
    private int userId;
    @SerializedName("cartItems")
    private List<CartItem> cartItems;
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
