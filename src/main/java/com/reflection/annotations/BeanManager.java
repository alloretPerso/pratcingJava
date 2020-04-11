package com.reflection.annotations;

import java.awt.datatransfer.SystemFlavorMap;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BeanManager {
    private static BeanManager instance = new BeanManager();
    private final Map<Class<?>, Supplier<?>> registry = new HashMap<>();

    public static final BeanManager getInstance() {
        return instance;
    }

    private BeanManager() {
        List<Class<?>> classes = List.of(Provider.class);
        for (Class<?> classes1 : classes) {
            Method[] methods = classes1.getDeclaredMethods();
            for (Method method : methods) {
                Provides annotation = method.getAnnotation(Provides.class);
                if (annotation != null) {
                    Class<?> returnType = method.getReturnType();
                    Supplier<?> supplier = () -> {
                        try {
                            if (!Modifier.isStatic(method.getModifiers())) {
                                Object o = classes1.getConstructor().newInstance();
                                return method.invoke(o);
                            } else {
                                return method.invoke(null);
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    };
                    registry.put(returnType, supplier);
                }
            }
        }
    }

    public <T> T getInstance(Class<T> class1) {
        try {
            T t = class1.getConstructor().newInstance();
            Field[] declaredFields = class1.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Inject annotation = declaredField.getAnnotation(Inject.class);
                if (annotation != null) {
                    Class<?> type = declaredField.getType();
                    Supplier<?> supplier = registry.get(type);
                    Object o = supplier.get();
                    declaredField.setAccessible(true);
                    declaredField.set(t, o);

                }

            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
