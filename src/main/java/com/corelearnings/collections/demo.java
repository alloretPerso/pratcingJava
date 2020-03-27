package com.corelearnings.collections;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        ArrayList<ClassEqualImplement> list = new ArrayList<>();
        ClassEqualImplement v1 = new ClassEqualImplement("v1", "abc");
        ClassEqualImplement v2 = new ClassEqualImplement("v2", "abc");
        ClassEqualImplement v3 = new ClassEqualImplement("v3", "abc");
        list.addAll(Arrays.asList(v1, v2, v3));

        list.remove(v3);
        System.out.println(list);

        Object[] objects1 = list.toArray();


        ClassEqualImplement[] myArray = {
                new ClassEqualImplement("v1", "abc"),
                new ClassEqualImplement("v2", "abc"),
                new ClassEqualImplement("v3", "abc")
        };

        Collection<ClassEqualImplement> classEqualImplements = Arrays.asList(myArray);

        ClassEqualImplement[] array1 = list.toArray(new ClassEqualImplement[0]);

        ClassEqualImplement[] array2 = new ClassEqualImplement[3];
        ClassEqualImplement[] array3 = list.toArray(array2);
        ClassEqualImplement[] array4 = new ClassEqualImplement[1];
        ClassEqualImplement[] array5 = list.toArray(array4);

        if (array2 == array3) System.out.println("reference the same array because space is enough");
        if (array4 != array5) System.out.println("don't reference the same array because not enough space");
        useOfThreeSetWithComparable();
        useOfThreeSetWithComparator();
        workOnAMap();
        workWithSortedMap();
    }

    public static final void useOfThreeSetWithComparable() {
        TreeSet<ClassEqualImplement> tree = new TreeSet<>();
        ClassEqualImplement[] myArray = {
                new ClassEqualImplement("2222", "abc"),
                new ClassEqualImplement("3333", "bbb"),
                new ClassEqualImplement("1111", "ddd")
        };
        List<ClassEqualImplement> classEqualImplements = Arrays.asList(myArray);
        tree.addAll(classEqualImplements);
        tree.forEach(System.out::println);

    }

    public static final void useOfThreeSetWithComparator() {
        TreeSet<ClassEqualImplement> tree = new TreeSet<>(new ClassEqualImplementBaseOnComparator());
        ClassEqualImplement[] myArray = {
                new ClassEqualImplement("2222", "abc"),
                new ClassEqualImplement("3333", "bbb"),
                new ClassEqualImplement("1111", "ddd")
        };
        List<ClassEqualImplement> classEqualImplements = Arrays.asList(myArray);
        tree.addAll(classEqualImplements);
        tree.forEach(System.out::println);
    }

    public static final void workOnAMap() {
        Map<String, String> map = new HashMap<>();
        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        String s = map.get("3333");
        String s1 = map.getOrDefault("9999", "xyz");

        map.forEach((k, v) -> System.out.println(k + " | " + v));
        map.replaceAll((k, v) -> v.toUpperCase());
        map.forEach((k, v) -> System.out.println(k + " | " + v));
    }

    public static final void workWithSortedMap(){
        SortedMap<String, String> map = new TreeMap<>();
        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");
        map.forEach((k, v) -> System.out.println(k + " | " + v));
        SortedMap<String, String> stringStringSortedMap = map.headMap("3333");
        stringStringSortedMap.forEach((k, v) -> System.out.println(k + " | " + v));
    }

}
