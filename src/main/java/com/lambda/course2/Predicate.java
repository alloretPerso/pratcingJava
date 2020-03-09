package com.lambda.course2;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> p2) {
        return value -> test(value) && p2.test(value);
    }
}
