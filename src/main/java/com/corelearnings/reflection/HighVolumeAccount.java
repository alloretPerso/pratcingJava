package com.corelearnings.reflection;

import java.util.Arrays;

public final class HighVolumeAccount extends BankAccount implements Runnable {

    private int[] listOfDeposit = new int[0];
    private int[] listOfWithdrawal= new int[0];

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    public final void addDeposit(int i) {
        listOfDeposit = Arrays.copyOf(listOfDeposit, listOfDeposit.length + 1);
        listOfDeposit[listOfDeposit.length-1] = i;
    }

    public final void addWithdrawal(int i) {
        listOfWithdrawal = Arrays.copyOf(listOfWithdrawal, listOfWithdrawal.length + 1);
        listOfWithdrawal[listOfWithdrawal.length-1] = i;
    }

    @Override
    public void run() {
        for (int i : listOfDeposit) {
            deposit(i);
        }
        for (int i : listOfWithdrawal) {
            withdrawal(i);
        }
    }
}
