package com.apiit.utilities;

import com.apiit.model.Cart;
import com.apiit.model.LoginResponse;
import com.apiit.model.Product;
import com.apiit.model.User;

import okhttp3.OkHttpClient;

public class Utilities {



    private static Cart FINAL_CART;
    private static User CURRENT_USER;
    private static String JWT_TOKEN;
    private static Double FINAL_CART_VALUE=0.00;


    public static Double getFinalCartValue() {
        return FINAL_CART_VALUE;
    }

    public static void setFinalCartValue(Double finalCartValue) {
        FINAL_CART_VALUE = finalCartValue;
    }

    public static Cart getFinalCart() {
        return FINAL_CART;
    }

    public static void setFinalCart(Cart finalCart) {
        FINAL_CART = finalCart;
    }

    public static User getCurrentUser() {
        return CURRENT_USER;
    }

    public static void setCurrentUser(User currentUser) {
        CURRENT_USER = currentUser;
    }

    public static String getJwtToken() {
        return JWT_TOKEN;
    }

    public static void setJwtToken(String jwtToken) {
        JWT_TOKEN = jwtToken;
    }
}
