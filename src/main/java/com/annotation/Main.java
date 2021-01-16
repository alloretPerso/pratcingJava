package com.annotation;

import java.lang.reflect.Method;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String keyWord = "add";
        Object[] mathProcessing = {new Add(), new Sub()};
        for (Object mathProcessing1 : mathProcessing) {
            CommandKeyword annotation = mathProcessing1.getClass().getAnnotation(CommandKeyword.class);
            String name = annotation.name();
            if (keyWord.equalsIgnoreCase(name)) {
                System.out.println("This is a " + name);
            }
        }
    }

    private static double handleCalculation(Object processor, double leftVal, double rightVal) {
        double result = 0d;
        try{
          CommandKeyword commandKeyword = processor.getClass().getAnnotation(CommandKeyword.class);
          String methodName = commandKeyword.method();
            Method processingMethod = processor.getClass().getMethod(methodName,double.class,double.class);
            result = (double) processingMethod.invoke(processor,leftVal,rightVal);
        } catch (Exception ex){
            System.out.println("Error accessing method - " + ex.toString());
        }
        return result;
    }
}
