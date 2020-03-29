package com.corelearnings.concurrency;

public class WorkerWithLocker implements Runnable {
    private BankAccount account;

    public WorkerWithLocker(BankAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "account=" + account +
                '}';
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (account){
                account.deposit(10);
                System.out.println(account);
            }
        }
    }
}
