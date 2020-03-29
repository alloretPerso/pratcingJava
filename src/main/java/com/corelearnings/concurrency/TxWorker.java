package com.corelearnings.concurrency;

public class TxWorker implements Runnable {
    protected BankAccountSafe account;
    protected  char txType;
    protected  int amt;

    public TxWorker(BankAccountSafe account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    @Override
    public void run() {
        if (txType == 'w')account.withdrawal(amt);
        else if (txType == 'd')account.deposit(amt);
    }
}
