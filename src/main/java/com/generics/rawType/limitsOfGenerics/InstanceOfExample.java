package com.generics.rawType.limitsOfGenerics;

public class InstanceOfExample<T> {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InstanceOfExample/*<T>*/) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceOfExample<>() instanceof Object);
    }
}
