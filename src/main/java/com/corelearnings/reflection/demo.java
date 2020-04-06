package com.corelearnings.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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
        getMethods(highVolumeAccount);
        callMethodFromReflection(highVolumeAccount);
        callAMethodWithArgument(highVolumeAccount,70);

    }

    public static final void callMethodFromReflection(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> theClass = o.getClass();
        Method getId = theClass.getMethod("getId");
        Object invoke = getId.invoke(o);
        System.out.println("Result id " + invoke);
    }

    public static final void callAMethodWithArgument(Object o, int i) {
        Class<?> theClass = o.getClass();
        Method deposit = null;
        try {
            deposit = theClass.getMethod("deposit", int.class);
            Object invoke = deposit.invoke(o, i);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static final void getMethods(Object o) {
        Class<?> theClass = o.getClass();
        Method[] methods = theClass.getMethods();
        Arrays.stream(methods)
                .filter(method -> method.getDeclaringClass() != Object.class)
                .forEach(System.out::println);
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
