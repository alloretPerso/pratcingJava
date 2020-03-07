package com.lambda.course1;

import java.util.Comparator;

public class demo {
    public static Comparator<String> oldFashion = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(),o2.length());
        }
    };
    public static Comparator<String> lambda = (String o1, String o2) -> Integer.compare(o1.length(),o2.length());

    public static Comparator<String> lambdaRefactored = Comparator.comparingInt(String::length);

    public static void main(String [] args){
    }
}
