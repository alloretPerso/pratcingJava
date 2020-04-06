package com.corelearnings.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException {
        BankAccount bankAccount1 = new BankAccount("1234");
        BankAccount bankAccount2 = new BankAccount("1234", 500);
        doWork(bankAccount1); //With type reference

        Class<?> c = Class.forName("com.corelearnings.reflection.BankAccount");
        showName(c);


        HighVolumeAccount highVolumeAccount = new HighVolumeAccount("1234", 500);
        highVolumeAccount.addDeposit(10);
        highVolumeAccount.addDeposit(500);
        highVolumeAccount.addDeposit(400);
        highVolumeAccount.withdrawal(350);
        highVolumeAccount.withdrawal(30);
        highVolumeAccount.withdrawal(45);

        highVolumeAccount.run();
        classInfo(highVolumeAccount);

    }

    public static final void classInfo(Object o) {
        Class<?> theClass = o.getClass();
        System.out.println(theClass.getSimpleName());
        Class<?> superclass = theClass.getSuperclass();
        System.out.println(superclass.getSimpleName());
        Class<?>[] interfaces = theClass.getInterfaces();
        Arrays.stream(interfaces)
                .map(Class::getSimpleName)
                .forEach(System.out::println);

        int modifiers = theClass.getModifiers();
        if (Modifier.isFinal(modifiers)) {
            System.out.println("This class is final");
        }

    }

    private static void doWork(Object o) {
        Class<?> c = o.getClass();
        showName(c);
    }

    private static void showName(Class<?> aClass) {
        System.out.println(aClass.getSimpleName());
    }
}
