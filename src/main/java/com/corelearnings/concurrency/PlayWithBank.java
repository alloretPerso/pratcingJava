package com.corelearnings.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayWithBank {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(10);


        /*notSafeMultiThreading(es, account);*/
        System.out.println("\n");
        BankAccountSafe accountSafe = new BankAccountSafe(100);
        /*safeMultiThreading(es,accountSafe);*/
        BankAccount account1 = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            WorkerWithLocker workerWithLocker = new WorkerWithLocker(account1);
            es.submit(workerWithLocker);
        }
        es.shutdown();
    }

    private static void notSafeMultiThreading(ExecutorService es, BankAccount account) {
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(account);
            es.submit(worker);
        } //Code not safe
    }
    private static void safeMultiThreading(ExecutorService es, BankAccountSafe account) {
        for (int i = 0; i < 5; i++) {
            WorkerSafe worker = new WorkerSafe(account);
            es.submit(worker);
        }
    }
}
