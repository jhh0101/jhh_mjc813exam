package com.mjc813.thread.test;

import com.mjc813.thread.Example.RunnableExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        try (ExecutorService es1 = Executors.newCachedThreadPool()) {
            es1.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(i);
                    }
                }
            });
            es1.shutdown();
        }
        try (ExecutorService es2 = Executors.newFixedThreadPool(10)) {
            es2.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("Hello");
                }
            });
            es2.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("World");
                }
            });
            es2.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("Java");
                }
            });

            es2.shutdownNow();
        }
    }
}
