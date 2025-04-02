package com.xcoder;

import java.util.concurrent.CompletableFuture;

public class Demo7 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return s.length();
        });

        transformedFuture.thenAcceptAsync(length -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Length Hello: " + length);
        });
    }
}
