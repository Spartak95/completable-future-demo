package com.xcoder;

import java.util.concurrent.CompletableFuture;

public class Demo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                Thread.currentThread().interrupt();
            }

            return "Hello, world!";
        });

        future.thenAccept(System.out::println);
    }
}
