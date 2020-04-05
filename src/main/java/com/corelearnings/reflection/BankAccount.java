package com.corelearnings.reflection;

public class BankAccount {
    private final String id;
    private int balance = 0;

    public String getId() {
        return id;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdrawal(int amount) {
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount(String id) {
        this.id = id;
    }
}
