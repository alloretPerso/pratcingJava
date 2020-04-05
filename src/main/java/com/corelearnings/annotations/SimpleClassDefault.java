package com.corelearnings.annotations;

@SimpleAnnotations
public class SimpleClassDefault implements Runnable {
    private String stringField;

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getStringField() {
        return stringField;
    }

    @Override
    public void run() {
        setStringField("Hello world");
    }
}
