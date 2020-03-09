package com.lambda.course2;

import java.util.function.Predicate;

public class demo {
    public static void main(String[] args) {
        //Predicate in JDK 7
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 20;
            }
        };
        //Predicate in JDK 8
        Predicate<String> pNew = s -> s.length() < 20;
    }
}
