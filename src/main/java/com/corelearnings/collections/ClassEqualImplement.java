package com.corelearnings.collections;

public class ClassEqualImplement implements Comparable {
    private String value1;
    private String value2;

    public String getValue2() {
        return value2;
    }

    @Override
    public boolean equals(Object o) {
        ClassEqualImplement other = (ClassEqualImplement) o;
        return value2.equalsIgnoreCase(other.getValue2());
    }

    public ClassEqualImplement(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "ClassEqualImplement{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ClassEqualImplement other = (ClassEqualImplement) o;
        return this.value1.compareToIgnoreCase(other.value1);
    }
}
