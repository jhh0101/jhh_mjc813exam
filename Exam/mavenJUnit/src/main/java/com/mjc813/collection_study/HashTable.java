package com.mjc813.collection_study;

import java.util.*;

public class HashTable {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>(); // synchronized 되어 있음
        Map<String, Integer> map1 = Collections.synchronizedMap(new HashMap<>()); // 멀티 스레드 안전

        Thread threadA = new Thread(){
            @Override
            public void run(){
                for(int i = 1; i <= 1000; i++){
                    map.put(String.valueOf(i), i);
                }
            }
        };
        Thread threadB = new Thread(){
            @Override
            public void run(){
                for(int i = 1001; i <= 2000; i++){
                    map.put(String.valueOf(i), i);
                }
            }
        };
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {  }

        int size = map.size();
        System.out.println("총 Entry 수 : " + size);
        System.out.println();
    }
}
