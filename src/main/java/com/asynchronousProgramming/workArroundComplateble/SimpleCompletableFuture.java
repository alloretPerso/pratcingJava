package com.asynchronousProgramming.workArroundComplateble;

import java.util.concurrent.CompletableFuture;

public class SimpleCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> cf = new CompletableFuture<>();
        Runnable task = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cf.complete(null);
        };
        CompletableFuture.runAsync(task);
        Void join = cf.join();
        System.out.println("We are done");

    }
}
