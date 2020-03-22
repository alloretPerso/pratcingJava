package com.generics.interf;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    public ReverseComparator(Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    private final Comparator<T> delegateComparator;


    @Override
    public int compare(final T left, final T right) {
        return -1 * delegateComparator.compare(left, right);
    }
}
