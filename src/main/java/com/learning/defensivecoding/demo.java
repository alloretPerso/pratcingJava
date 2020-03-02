package com.learning.defensivecoding;

import java.util.Objects;

public class demo {
    public static void main (String [] args){
        System.out.println("Hello world");
        //firstCheck();
    }

    private void firstCheck() {
        SimpleClass simpleClass = new SimpleClass(1,"test");
        Objects.requireNonNull(simpleClass, "Cannot be null");

    }

    class SimpleClass{
        private int val1;
        private String val2;

        public SimpleClass(int val1, String val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public int getVal1() {
            return val1;
        }

        public String getVal2() {
            return val2;
        }
    }
}
