package com.generics.rawType.limitsOfGenerics;

public class UncompilableException/*<T>*/ extends Exception {
    public static void main(String[] args) {
        try {
            throw new UncompilableException();
        } catch (UncompilableException e) {
            e.printStackTrace();
        }
    }
}
