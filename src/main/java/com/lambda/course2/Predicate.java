package com.lambda.course2;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> p2) {
        return value -> test(value) && p2.test(value);
    }

    default Predicate<T> or(Predicate<T> p2) {
        return value -> test(value) || p2.test(value);
    }

    static Predicate<String> isEqualsTo(String string){
        return s -> s.equals(string);
    }
}
