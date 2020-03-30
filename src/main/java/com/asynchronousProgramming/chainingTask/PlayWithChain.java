package com.asynchronousProgramming.chainingTask;

import com.google.common.base.Supplier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class PlayWithChain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Supplier<List<Long>> listSupplier =
                () -> List.of(1L, 2L, 3L);

        CompletableFuture<List<User>> cf2 =
                CompletableFuture.supplyAsync(listSupplier)
                .thenApply(PlayWithChain::readUsers);

        List<User> users = cf2.get();
        System.out.println(users);
    }

    private static List<User> readUsers(List<Long> list) {
        return list.stream()
                .map(id -> new User(id, "Bob"))
                .collect(Collectors.toList());
    }
}
