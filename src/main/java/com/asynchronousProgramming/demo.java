package com.asynchronousProgramming;

import java.util.concurrent.*;

public class demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        basicExecutionRunnable();
        basicExecutionCallable();
        patternToNotUse();
        correctPatternToUse();
        workWithCompletableFuture();

    }

    private static void workWithCompletableFuture() {
        Runnable task =() -> System.out.println("Hello world from completable future");
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.runAsync(task);
        CompletableFuture<Void> voidCompletableFutureBis =
                CompletableFuture.runAsync(task,executorService);
        executorService.shutdown();
    }

    private static void correctPatternToUse() {
        Runnable task=() -> System.out.println("Hello world from executor pattern");
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(task);
        service.shutdown();
    }

    private static void patternToNotUse() {
        Runnable task = () -> System.out.println("Hello world from thread");
        Thread thread = new Thread(task);
        thread.start();
    }

    private static void basicExecutionCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Callable<String> callable = () -> {
            return "Hello world from callable";
        };
        Future<String> submit = executorService.submit(callable);
        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
    }

    private static void basicExecutionRunnable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> {
            System.out.println("Hello worlds");
        };
        Future submit = executorService.submit(task);
        Object o = submit.get();
        executorService.shutdown();
    }
}
