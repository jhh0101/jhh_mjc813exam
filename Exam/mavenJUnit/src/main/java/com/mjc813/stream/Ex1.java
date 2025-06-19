package com.mjc813.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list1.add((int) (Math.random()*1000+1));
        }

//        Map<Boolean, List<Integer>> collect = list1.stream()
//                .sorted()
//                .collect(Collectors.partitioningBy(a -> a > 500));
//        System.out.println(collect);
    }
}
