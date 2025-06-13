package com.mjc813.collection_study;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java"); //중복 안됨
        set.add("Spring");

        int size = set.size();
        System.out.println(size);

        printSetArr(set);

        System.out.println();
        set.remove("JSP");
        printSetArr(set);

    }
    public static void printSetArr(Set<String> set){
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
