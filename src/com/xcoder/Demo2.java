package com.xcoder;

import java.util.concurrent.CompletableFuture;

public class Demo2 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
            .thenApplyAsync(result -> result * 2)
            .thenApplyAsync(result -> result + 5);

        future.thenAccept(System.out::println);
    }
}
