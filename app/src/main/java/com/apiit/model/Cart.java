package com.apiit.model;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {
    private int cartId;
    private User user;
    private List<Product> products;
    private LocalDateTime cartDateTime;

    public Cart(int cartId, User user, List<Product> products, LocalDateTime cartDateTime) {
        this.cartId = cartId;
        this.user = user;
        this.products = products;
        this.cartDateTime = cartDateTime;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getCartDateTime() {
        return cartDateTime;
    }

    public void setCartDateTime(LocalDateTime cartDateTime) {
        this.cartDateTime = cartDateTime;
    }
}
