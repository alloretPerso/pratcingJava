package com.lambda.course1;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

 /*   //default Comparator<T> thenComparing(Function<T, Comparable> function) {
        return (p1,p2) -> function.apply()
    }*/

    static Comparator<Person> comparing(Function<Person, String> f) {
        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }


}
