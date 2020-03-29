package com.asynchronousProgramming.workArroundComplateble;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureWithSupplier {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        };
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(supplier, executorService);
        String join = stringCompletableFuture.join();
        System.out.println("Result = " + join);
        stringCompletableFuture.obtrudeValue("Too long");
        join = stringCompletableFuture.join();
        System.out.println("Result = " + join);
        executorService.shutdown();
    }
}
