package com.generics.reflection;

public class demo {
    public static void main(String[] args) {
        Injector injector = new Injector().with(new Logger("Hello world"));
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
