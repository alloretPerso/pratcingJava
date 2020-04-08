package com.reflection.annotations;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {
    void persist(T t) throws IllegalAccessException;
    /*T read(Class<?> clzz,long primaryKey);*/

    static <T> EntityManager<T> of(Class<T> clss) {
        return new H2EntityManager<>();
    }

    T find(Class<T> tClass, Object primaryKey) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
