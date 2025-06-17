package com.mjc813.ramda;

import java.util.ArrayList;
import java.util.List;

public class ProcessMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        Process hm = new Process("정해훈", 23);
        Process car = new Process("아우디", 22);
        Process num = new Process(list);

        hm.printString(((str, age) -> System.out.printf("{%s} 님의 나이는 {%d} 입니다.\n", str, age)));
        car.printString(((str, age) -> System.out.printf("자동차 {%s} 의 년식은 {%d} 입니다.\n", str, age)));
        num.number(ProcessMain::sum);
        num.number(ProcessMain::avg);
    }

    private static Long sum(List<Integer> list) {
        Long sum = 0L;
        for (Integer i : list) {
            sum += i;
        }
        System.out.printf("합은 {%d} 입니다.\n", sum);
        return sum;
    }

    private static Long avg(List<Integer> list) {
        Long sum = 0L;
        for (Integer i : list) {
            sum += i;
        }
        Long avg = sum / list.size();
        System.out.printf("평균은 {%d} 입니다.\n", avg);
        return avg;
    }
}
