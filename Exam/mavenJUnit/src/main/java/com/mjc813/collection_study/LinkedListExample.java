package com.mjc813.collection_study;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            list1.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList : "+(endTime - startTime) + "ns");

        startTime = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            list2.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList : "+(endTime - startTime) + "ns");


    }
}
