package com.generics.interf;

public class SortedPair<T extends Comparable<T>> {
    private T fist;
    private T second;

    public SortedPair(T left, T right) {
        if (left.compareTo(right) < 0){
            this.fist = left;
            this.second = right;
        }else {
            this.fist = right;
            this.second = left;
        }
    }

    public T getFist() {
        return fist;
    }

    public T getSecond() {
        return second;
    }
}
