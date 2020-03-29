package com.asynchronousProgramming.workArroundComplateble;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstCompletableFutur {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable i_am_runninumg_assync = () -> {
            System.out.println("I am running async the current thread is : "+ Thread.currentThread().getName());
        };
        CompletableFuture.runAsync(i_am_runninumg_assync,executorService);
        CompletableFuture.runAsync(i_am_runninumg_assync); // -> Thread come from the fork join pool
        executorService.shutdown();
    }
}
