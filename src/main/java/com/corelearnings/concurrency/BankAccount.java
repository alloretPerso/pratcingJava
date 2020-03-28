package com.corelearnings.concurrency;

public class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
