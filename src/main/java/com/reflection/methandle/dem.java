package com.reflection.methandle;


import com.reflection.Person;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

public class dem {
    public static void main(String[] args) throws Throwable {
        try {
            Person person = new Person("lea", 23);

            MethodHandles.Lookup lookup = MethodHandles.lookup();


            //Simple class
            Class<?> aClass = MethodHandles.lookup()
                    .findClass(Person.class.getName());

            //Method get
            MethodType methodType = MethodType.methodType(String.class);
            MethodHandle methodHandle = lookup.findVirtual(Person.class, "getName", methodType);
            System.out.println(methodHandle.invoke(person));
            //Method set
            MethodType methodType2 = MethodType.methodType(void.class, String.class);
            MethodHandle methodHandle2 = lookup.findVirtual(Person.class, "setName", methodType2);
            methodHandle2.invoke(person, "jhon");
            System.out.println(person);
            //Constructor by convention return void
            MethodType methodType1 = MethodType.methodType(void.class, String.class, int.class);
            MethodHandle constructor = lookup.findConstructor(Person.class, methodType1);

            //Default constructor
            MethodType methodType3 = MethodType.methodType(void.class);
            MethodHandle constructorEmpty = lookup.findConstructor(Person.class, methodType3);


            //On a field

/*            MethodHandle nameGetter = lookup.
                    findGetter(Person.class, "name", String.class); //Read only for public
            MethodHandle nameWriter = lookup
                    .findSetter(Person.class, "name", String.class);// Write*/

            MethodHandles.Lookup privateLookupIn = MethodHandles.privateLookupIn(Person.class, lookup);
            MethodHandle privateLookupInGetter = privateLookupIn
                    .findGetter(Person.class, "name", String.class);//Read private field
            String namePostJava9 = (String) privateLookupInGetter.invoke(person);
            System.out.println(namePostJava9);


            Field nameField = Person.class.getDeclaredField("name");
            nameField.setAccessible(true);
            MethodHandle methodHandle1 = lookup.unreflectGetter(nameField);
            String invoke = (String) methodHandle1.invoke(person);

            VarHandle nameVarHandle = MethodHandles.privateLookupIn(Person.class,lookup)
                    .findVarHandle(Person.class,"name",String.class);
            String name = (String) nameVarHandle.get(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
