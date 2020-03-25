package com.generics.rawType;

import java.util.AbstractList;

public class CustomArrayList<T> extends AbstractList<T> {
    //private T[] values;
    private Object[] values;
    public CustomArrayList() {
        values = new Object[0];
    }

    public int size() {
        return values.length;
    }

    public boolean add(T o) {
        //T[] newValue = (T[]) new Object[size() + 1];
        Object[] newValue = new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            newValue[i] = values[i];
        }
        newValue[size()] = o;
        values = newValue;
        return true;
    }

    public T get(int index) {
        //return values[index];
        return (T) values[index];
    }

    public static void main(String[] args) {

    }
}
