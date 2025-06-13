package com.mjc813.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        try (ExecutorService es1 = Executors.newCachedThreadPool()) {
            es1.shutdown();
//            es1.execute();
        }
        try (ExecutorService es2 = Executors.newFixedThreadPool(10)) {
            es2.shutdownNow();
//            es1.execute();
        }
    }
}
