package com.corelearnings.reflection;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException {
        BankAccount bankAccount1 = new BankAccount("1234");
        BankAccount bankAccount2 = new BankAccount("1234", 500);
        doWork(bankAccount1); //With type reference

        Class<?> c = Class.forName("com.corelearnings.reflection.BankAccount");
        showName(c);
    }

    private static void doWork(Object o) {
        Class<?> c = o.getClass();
        showName(c);
    }

    private static void showName(Class<?> aClass) {
        System.out.println(aClass.getSimpleName());
    }
}
