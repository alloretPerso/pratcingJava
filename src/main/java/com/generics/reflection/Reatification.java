package com.generics.reflection;

import java.util.ArrayList;
import java.util.List;

public class Reatification<T> {
    public static void main(String[] args) {
        System.out.println(int.class);
        System.out.println(String.class);
        List<?> wildcards = new ArrayList<>();
        System.out.println(wildcards.getClass());
        List raw = new ArrayList();
        System.out.println(raw);
        System.out.println(raw.getClass() == wildcards.getClass());
        System.out.println(int[].class);
        System.out.println(List[].class);
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass());
        System.out.println(integers.getClass());
        System.out.println(integers.getClass() == strings.getClass());

        List<? extends Number> numbers = new ArrayList<>();
        System.out.println(numbers.getClass());
        System.out.println(integers.getClass() == numbers.getClass());
    }

}
