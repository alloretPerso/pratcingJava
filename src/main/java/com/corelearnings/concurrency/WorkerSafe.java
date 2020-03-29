package com.corelearnings.concurrency;

public class WorkerSafe implements Runnable {
    private BankAccountSafe account;

    public WorkerSafe(BankAccountSafe account) {
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
            int startBalance = account.getBalance();
            account.deposit(10);
            int endBalance = account.getBalance();
            System.out.println(this);
        }
    }
}
