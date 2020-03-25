package com.generics.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectGeneric {
    public static class StringList extends ArrayList<String>{

    }
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();

        TypeVariable<? extends Class<?>>[] typeVariables = arrayList.getTypeParameters();
        System.out.println(Arrays.toString(typeVariables)); // [E]

        System.out.println(arrayList.toGenericString()); // public class java.util.ArrayList<E>

        ParameterizedType genericSuperclass = (ParameterizedType)
                StringList.class.getGenericSuperclass();
        System.out.println(Arrays.toString(genericSuperclass
                .getActualTypeArguments())); // [class java.lang.String]

    }
}
