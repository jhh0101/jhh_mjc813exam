package com.mjc813.collection_study;

import java.util.*;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java"); // 중복 안됨
        set.add("Spring");
        set.add(null);  // null 가능

        int size = set.size();
        System.out.println(size);

        printSetArr(set);

        System.out.println();
        set.remove("JSP"); // "JSP" 삭제
        printSetArr(set);
    }

    public static void printSetArr(Set<String> set){
        for (String s : set) {
            System.out.print(s + ", ");
        }
    }


}
