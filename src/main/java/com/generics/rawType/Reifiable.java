package com.generics.rawType;

import java.util.List;

public class Reifiable {

    public static void main(String[] args) {
/*        String[] strings = new String[3];
        Object[] objecs = strings; // can do because covariant
        objecs[0] = 1;*/

        List arrayList = new CustomArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
    }
}
