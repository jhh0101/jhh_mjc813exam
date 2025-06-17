package com.mjc813.collection_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) throws InterruptedException {
        List<Board> list = new Vector<>();
        List<String> list2 = Collections.synchronizedList(new ArrayList<>()); // 멀티스레드 안전

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                list.add(new Board("제목 : " + i,"내용 : " + i,"글쓴이 : " + i));
            }
        });

        Thread threadB = new Thread(()->{
            for (int i = 1001; i <= 2000; i++) {
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
        System.out.println();
    }
}
