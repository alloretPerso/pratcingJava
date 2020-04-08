package com.reflection.annotations;

import com.reflection.Person;

import java.lang.reflect.Field;
import java.util.List;

public class WorkWithReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Jhon", 34);
        editAPrivateField(person);
        Metamodel metamodel = Metamodel.of(Person.class);
        PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        List<ColumnField> columnList = metamodel.getColumns();

        System.out.println("Primary key name =" + primaryKeyField.getName()
                                + ", type = "+ primaryKeyField.getType().getSimpleName());

        columnList.stream().forEach( columnField ->
                System.out.println("Column key name =" + columnField.getField().getName()
                        + ", type = "+ columnField.getType().getSimpleName())
        );
    }

    private static void editAPrivateField(Person person) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = person.getClass();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Sarah");
        System.out.println(person);
    }
}
