package com.reflection;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException {
        String personClassName = "com.reflection.Person";
        Class<?> aClass = Class.forName(personClassName);
        System.out.println(aClass);

        Field[] fields = aClass.getFields();
        System.out.println(Arrays.toString(fields));
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        Method[] methods = aClass.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .forEach(System.out::println);
    }
}
