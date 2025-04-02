package com.xcoder;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> asyncOp = CompletableFuture.runAsync(CompletableFutureDemo::doAsyncOperation);
        doSomethingElse();
        asyncOp.join();

        Future<String> stringFuture = CompletableFuture.completedFuture("hello");
        String result = stringFuture.get();
        assert Objects.equals(result, "hello");

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("Hello"));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Beautiful"));
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> System.out.println("World"));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        // ...

        combinedFuture.get();
    }

    private static void doSomethingElse() {
        // ...
    }

    private static void doAsyncOperation() {
        // ...
    }

    private static Future<String> calculateAsync() {
        CompletableFuture<String> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            future.complete("hello");
            return null;
        });

        return future;
    }
}
