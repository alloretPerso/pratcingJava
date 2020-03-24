package com.generics.rawType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo {
    public static void main(String[] args){

        List<Object> list = new ArrayList();
        list.add("abs");
        list.add(1);
        list.add(new Object());

        //List<String> bis = list; -> block with generic upper level

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        legacyMethod(integers);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            Object element = iterator.next();
            System.out.println(element);
        }

    }

    private static void legacyMethod(List integers) {

    }
}
