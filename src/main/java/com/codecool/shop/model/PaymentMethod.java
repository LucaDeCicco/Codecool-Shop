package com.codecool.shop.model;

public class PaymentMethod {
    String method;
    private static Client instance = null;

    public PaymentMethod() {
    }

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
