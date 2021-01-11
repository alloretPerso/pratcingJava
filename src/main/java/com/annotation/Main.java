package com.annotation;

public class Main {
    public static void main(String[] args) {
        String keyWord = "add";
        MathProcessing[] mathProcessing = {new Add(), new Sub()};
        for (MathProcessing mathProcessing1 : mathProcessing) {
            CommandKeyword annotation = mathProcessing1.getClass().getAnnotation(CommandKeyword.class);
            String name = annotation.name();
            if (keyWord.equalsIgnoreCase(name)) {
                System.out.println("This is a " + name);
            }
        }
    }
}
