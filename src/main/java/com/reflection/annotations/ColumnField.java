package com.reflection.annotations;

import java.lang.reflect.Field;

public class ColumnField {
    private Field field;
    private Column column;

    public ColumnField(Field field) {

        this.field = field;
        this.column = this.field.getAnnotation(Column.class);
    }

    public Class<?> getType() {
        return field.getType();
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return column.name();
    }
}
