package com.reflection.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Metamodel {


    private Class<?> clss;

    public static Metamodel of(Class<?> clss) {

        return new Metamodel(clss);
    }

    public Metamodel(Class<?> clss) {

        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] declaredFields = clss.getDeclaredFields();
        for (Field field : declaredFields) {
            PrimaryKey annotation = field.getAnnotation(PrimaryKey.class);
            if (annotation != null) {
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
            if (annotation != null) {
                ColumnField columnField = new ColumnField(field);
                columnFieldList.add(columnField);
            }
        }
        return columnFieldList;
    }

    public String buildInsertRequest() {
        String columnElement = buildColumnNames();
        String questionMarksElement = buildQuestionMarksElement();

        return "insert into " + this.clss.getSimpleName() + " (" + columnElement + ") values (" + questionMarksElement + ")";
    }

    private String buildQuestionMarksElement() {
        int i = getColumns().size() + 1;
        return IntStream.range(0, i)
                .mapToObj(index -> "?")
                .collect(Collectors.joining(", "));
    }

    private String buildColumnNames() {
        String primaryKey = getPrimaryKey().getName();
        List<String> collect = getColumns().stream()
                .map(columnField -> columnField.getField().getName())
                .collect(Collectors.toList());
        collect.add(0, primaryKey);
        return String.join(",", collect);
    }

    public String buildSelectRequest() {
        String columnElement = buildColumnNames();

        return "select " + columnElement + " from " + this.clss.getSimpleName() +
                " where " + getPrimaryKey().getName() + "= ?";
    }
}
