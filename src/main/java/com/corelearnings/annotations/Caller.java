package com.corelearnings.annotations;

public class Caller {
    private SimpleClass simpleClass;

    public Caller(SimpleClass simpleClass) {
        this.simpleClass = simpleClass;
    }
    public void init() {
        SimpleClass simpleClass  = new SimpleClass();
        SimpleAnnotations annotations = simpleClass.getClass().getAnnotation(SimpleAnnotations.class);
        if (!annotations.simpleMethod()){
            System.out.println("I work");
        }

        SimpleClassDefault simpleClassDefault = new SimpleClassDefault();
        SimpleAnnotations simpleAnnotations = simpleClassDefault.getClass().getAnnotation(SimpleAnnotations.class);

        if (simpleAnnotations.simpleMethod()){
            System.out.println("I work too");
        }
    }
}
