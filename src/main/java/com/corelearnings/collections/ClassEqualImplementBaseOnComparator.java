package com.corelearnings.collections;


import java.util.Comparator;

public class ClassEqualImplementBaseOnComparator implements  Comparator<ClassEqualImplement> {

    @Override
    public int compare(ClassEqualImplement x, ClassEqualImplement y) {
        return x.getValue2().compareToIgnoreCase(y.getValue2());
    }
}
