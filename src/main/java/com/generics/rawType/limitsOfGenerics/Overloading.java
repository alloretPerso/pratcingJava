package com.generics.rawType.limitsOfGenerics;

import java.util.List;

public class Overloading {
    public void print(String param){

    }
    public void print(Integer param){

    }
    public void print(List<String> param){

    }
/*    public void print(List<Integer> param){

    }
    both methods have same erasure
    */
}
