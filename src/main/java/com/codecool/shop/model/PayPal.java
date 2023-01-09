package com.codecool.shop.model;

public class PayPal {
    private final String username;
    private final String password;

    public PayPal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
