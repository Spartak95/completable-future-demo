package com.xcoder.thencompose;

import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        CompletableFuture<Order> futureOrder = userService.getUserById(1)
            .thenCompose(user -> orderService.getOrdersByUserId(user.getId()));

        futureOrder
            .thenAccept(order -> System.out.println(
                "Order fetched for user: " + order.getUserId() + " -> Item: " + order.getItem())
            ).join();
    }
}
