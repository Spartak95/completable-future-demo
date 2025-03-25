package com.xcoder.thencompose;

import java.util.concurrent.CompletableFuture;

public class UserService {

    public CompletableFuture<User> getUserById(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user...");
            SleepUtil.sleep(1000);
            return new User(userId, "John Doe");
        });
    }
}
