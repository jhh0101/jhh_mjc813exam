package com.mjc813.stream;

import com.mjc813.thread.Log;

import java.util.ArrayList;
import java.util.List;

public class Parallel {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list1.add((int) (Math.random()*1000+1));
        }
        Log log = new Log();
        list1.parallelStream().forEach(log::log); // 다른 쓰레드로 작동
        list1.forEach(log::log);


    }

}
