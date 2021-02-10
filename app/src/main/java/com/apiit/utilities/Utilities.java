package com.apiit.utilities;

import com.apiit.model.Cart;
import com.apiit.model.User;

public class Utilities {

    private static Cart FINAL_CART;
    private static User CURRENT_USER;
    private static String JWT_TOKEN;
    private static Double FINAL_CART_VALUE=0.00;
    private static String HOST_IP_ADDRESS = "http://192.168.1.102";

    public static String getHostIpAddress() {
        return HOST_IP_ADDRESS;
    }

    public static void setHostIpAddress(String hostIpAddress) {
        HOST_IP_ADDRESS = hostIpAddress;
    }

    public static Double getFinalCartValue() {
        return FINAL_CART_VALUE;
    }

    public static void setFinalCartValue(Double finalCartValue) { FINAL_CART_VALUE = finalCartValue; }

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
