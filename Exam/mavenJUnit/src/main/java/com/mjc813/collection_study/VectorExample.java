package com.mjc813.collection_study;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorExample {
    public static void main(String[] args) throws InterruptedException {
        List<Board> list = new Vector<>(); // 제일 안좋음
        List<Board> list2 = Collections.synchronizedList(new LinkedList<>()); // 멀티스레드 안전, Vector 보단 나음
        CopyOnWriteArrayList<Board> list3 = new CopyOnWriteArrayList<>(); // 멀티스레드 안전, 제일 좋음(읽기 최적화)
        Long ms = System.currentTimeMillis();
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                list.add(new Board("제목 : " + i,"내용 : " + i,"글쓴이 : " + i));
            }
        });

        Thread threadB = new Thread(()->{
            for (int i =10001; i <= 20000; i++) {
                list.add(new Board("제목 : " + i,"내용 : " + i,"글쓴이 : " + i));
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int size = list.size();
        System.out.println("총 객체 수 : " + size);
        ms = System.currentTimeMillis() - ms;
        System.out.printf("totalMills = %d\n", ms);
        System.out.println();
    }
}
