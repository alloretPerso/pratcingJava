package com.corelearnings.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        String in = "src/main/java/com/corelearnings/concurrency/in.txt";
        String out = "src/main/java/com/corelearnings/concurrency/out.txt";

        String[] inFiles = {in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in, in};
        String[] outFiles = {out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out, out};
        System.out.println("Start");
        try {
            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();
            }
        } catch (IOException e) {

        }
        System.out.println("first");

        //To multithread
        toMultithreadNoWaiting(inFiles, outFiles);
        System.out.println("Second");
        toMultithreadWithWaiting(inFiles, outFiles);
        System.out.println("Third");

        multiThreadingWithTreadPool(inFiles, outFiles);
        System.out.println("Fourth");
    }

    private static void multiThreadingWithTreadPool(String[] inFiles, String[] outFiles) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }
        try{
            es.shutdown();
        }catch(Exception e){

        }
    }

    private static void toMultithreadWithWaiting(String[] inFiles, String[] outFiles) throws InterruptedException {
        Thread[] threads = new Thread[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }
        for (Thread thread : threads) thread.join(); //Blocks waiting for thread to finish
    }

    private static void toMultithreadNoWaiting(String[] inFiles, String[] outFiles) {
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            Thread thread = new Thread(adder);
            thread.start();
        }
    }
}
