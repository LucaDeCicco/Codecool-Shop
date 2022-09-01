package com.codecool.shop.model;

public class CreditCard {
    private String number;
    private String name;
    private String cvv;

    public CreditCard(String number, String name, String cvv) {
        this.number = number;
        this.name = name;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCvv() {
        return cvv;
    }
}
