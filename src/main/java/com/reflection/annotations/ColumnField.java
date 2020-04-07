package com.reflection.annotations;

import java.lang.reflect.Field;

public class ColumnField {
    private Field field;

    public ColumnField(Field field) {

        this.field = field;
    }

    public Class<?> getType() {
        return field.getType();
    }

    public Field getName() {
        return field;
    }
}
