package com.corelearnings.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayWithBankBis {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccountSafe bankAccountSafe = new BankAccountSafe(100);
        TxPromoWorker[] workers = {
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100), new TxPromoWorker(bankAccountSafe, 'w', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100), new TxPromoWorker(bankAccountSafe, 'w', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'd', 800), new TxPromoWorker(bankAccountSafe, 'w', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'd', 500), new TxPromoWorker(bankAccountSafe, 'd', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100), new TxPromoWorker(bankAccountSafe, 'd', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 500), new TxPromoWorker(bankAccountSafe, 'd', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100), new TxPromoWorker(bankAccountSafe, 'w', 34),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 1120), new TxPromoWorker(bankAccountSafe, 'w', 100),
                new TxPromoWorker(bankAccountSafe, 'd', 100), new TxPromoWorker(bankAccountSafe, 'w', 100), new TxPromoWorker(bankAccountSafe, 'w', 100)};
        for (TxPromoWorker worker : workers) {
            executorService.submit(worker);
        }
        executorService.shutdown();
        System.out.println(bankAccountSafe);
    }
}
