package com.reflection.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Metamodel<T> {


    private Class<T> clss;

    public static <T> Metamodel of(Class<T> clss) {

        return new Metamodel(clss);
    }

    public Metamodel(Class<T> clss) {

        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] declaredFields = clss.getDeclaredFields();
        for (Field field : declaredFields) {
            PrimaryKey annotation = field.getAnnotation(PrimaryKey.class);
            if (annotation != null){
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        return null;
    }

    public List<ColumnField> getColumns() {
        Field[] declaredFields = clss.getDeclaredFields();
        List<ColumnField> columnFieldList = new ArrayList<>();
        for (Field field : declaredFields) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation != null){
                ColumnField columnField = new ColumnField(field);
                columnFieldList.add(columnField);
            }
        }
        return columnFieldList;
    }
}
