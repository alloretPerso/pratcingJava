package com.corelearnings.annotations;

public class UseAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClass simpleClass = new SimpleClass();
        simpleClass.setStringField("Hello world");

        Caller caller = new Caller(simpleClass);
        caller.init();
    }
}
