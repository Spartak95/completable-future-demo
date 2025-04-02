package com.xcoder;

import java.util.concurrent.CompletableFuture;

public class Demo5 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        }).exceptionally(ex -> {
            System.out.println("future2 failed: " + ex.getMessage());
            return null; // Return a default value or null
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 20;
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.thenRun(() -> {
            // All futures completed
            Integer result1 = future1.join();
            Integer result2 = future2.join();
            Integer result3 = future3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        });
    }
}
