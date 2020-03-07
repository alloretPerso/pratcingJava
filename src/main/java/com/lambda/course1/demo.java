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

    public static Runnable r = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++ < 10){
                System.out.println("It works !");
            }
        }
    };

    public static Runnable rLambda = () -> {
        int i = 0;
        while (i++ < 10){
            System.out.println("It works !");
        }
    };

    public static void main(String [] args){
        rLambda.run();
    }
}
