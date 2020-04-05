package com.corelearnings.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SimpleAnnotations(simpleMethod = false)
public class SimpleClass implements Runnable {
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
