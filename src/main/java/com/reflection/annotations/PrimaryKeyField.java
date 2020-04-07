package com.reflection.annotations;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private Field field;

    public PrimaryKeyField(Field field) {

        this.field = field;
    }

    public Field getName() {
        return field;
    }

    public Class<?> getType() {
        return field.getClass();
    }
}
