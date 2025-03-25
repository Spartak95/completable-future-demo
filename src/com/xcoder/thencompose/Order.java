package com.xcoder.thencompose;

public class Order {
    private int userId;
    private String item;

    public Order(int userId, String item) {
        this.userId = userId;
        this.item = item;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
