package com.corelearnings.annotations;

import com.google.common.collect.Streams;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public class UseAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClass simpleClass = new SimpleClass();
        simpleClass.setStringField("Hello world");

        Caller caller = new Caller(simpleClass);
        caller.init();
    }
}
