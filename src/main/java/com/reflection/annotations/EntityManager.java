package com.reflection.annotations;

public interface EntityManager<T> {
    void persist(T t);
    T read(Class<?> clzz,long primaryKey);
}
