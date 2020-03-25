package com.generics.reflection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    public Injector with(Object value) {
        objectGraph.put(value.getClass(), value);
        return this;
    }

    public <T> T newInstance(Class<T> className) {
        return (T) objectGraph.computeIfAbsent(className, this::instiante);
    }

    private Object instiante(Class<?> type) {
        try {
            Constructor<?>[] constructors = type.getConstructors();
            if (constructors.length != 1) {
                throw new IllegalArgumentException(type + " must only have 1 constructor");
            }
            return this.with(constructors[0].newInstance(String.class));
        } catch (Exception e) {
            //return null;
        }
        return null;
    }

}
