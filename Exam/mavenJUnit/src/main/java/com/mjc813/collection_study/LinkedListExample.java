package com.mjc813.collection_study;

import java.util.List;
import java.util.Vector;

public class LinkedListExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new Vector<>();
        List<String> list2 = new Vector<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) + "ns");

        startTime = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) + "ns");


    }
}
