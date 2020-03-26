package com.generics.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarargsExample {
    public static void main(String[] args) {
        Integer[] integers = arrayOf(1, 2);
        System.out.println(Arrays.toString(integers));
        System.out.println(integers.getClass());

        Object[] strs = pair("a");
        System.out.println(Arrays.toString(strs));
        System.out.println(strs.getClass());

/*      Integer[] pair = pair(1);
        System.out.println(Arrays.toString(pair)); //That is a heap pollution uncertity on the type at runtime
        System.out.println(pair.getClass());*/     //The type will be erase at compile time

    }

    private static final <T> T[] pair(T t) {
        return arrayOf(t, t);
    }

    public static final <T> T[] arrayOf(T... values) {
        return values;
    }

    @SafeVarargs
    private static <T> List<T> combine(List<? extends T>... lists) {

        List<T> combined = new ArrayList<>();
        for (List<? extends T> list : lists) {
            combined.addAll(list);
        }
        return combined;
    }
}
