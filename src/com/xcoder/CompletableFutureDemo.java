package com.xcoder;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // Переданная лямбда будет выполнена в другом потоке.
        CompletableFuture<Void> asyncOp = CompletableFuture.runAsync(CompletableFutureDemo::doAsyncOperation);

        // Пока она выполняется, текущий поток может заняться чем-то ещё.
        doSomethingElse();

        // А после дождаться выполнения асинхронной операции.
        asyncOp.join();
    }

    private static void doSomethingElse() {
        // ...
    }

    private static void doAsyncOperation() {
        // ...
    }
}
