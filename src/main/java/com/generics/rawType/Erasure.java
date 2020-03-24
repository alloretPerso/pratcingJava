package com.generics.rawType;

import java.util.List;

public class Erasure<T, B extends Comparable<B>> {
    public void unbounded(T param) {

    }

    public void lists(List<String> param, List<List<T>> param2) {
        String s = param.get(0);
    }

    public void bounded(B param) {

    }
}
//check with javap -c to see the compile check descriptor metadata to see the Generic erase
/*
List<String>, List<Integer> -> List
        List<String> -> List
        T without bounds -> Object
        T extends Foo -> Foo*/
