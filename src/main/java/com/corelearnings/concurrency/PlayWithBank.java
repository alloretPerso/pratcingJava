package com.corelearnings.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayWithBank {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(10);


        notSafeMultiThreading(es, account);

        es.shutdown();
    }

    private static void notSafeMultiThreading(ExecutorService es, BankAccount account) {
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(account);
            es.submit(worker);
        } //Code not safe
    }
}
