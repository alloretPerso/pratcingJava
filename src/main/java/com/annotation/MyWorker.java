package com.annotation;

public class MyWorker {
    @SuppressWarnings("deprecation")
    void doSomeWork(){
        Doer d1 = new Doer();
        d1.doTheThing();
    }
    @SuppressWarnings("deprecation")
    void doDoubleWork(){
        Doer d2 = new Doer();
        d2.doTheThing();
        d2.doTheThing();
    }

    private class Doer {
        @Deprecated
        public void doTheThing() {

        }
        public void doTheThingNew(){

        }
    }
}
