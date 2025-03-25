package com.xcoder.thencompose;

import java.util.concurrent.CompletableFuture;

public class OrderService {

    public CompletableFuture<Order> getOrdersByUserId(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching orders for user: " + userId);
            SleepUtil.sleep(1000); // simulating delay
            return new Order(userId, "Laptop");
        });
    }
}
