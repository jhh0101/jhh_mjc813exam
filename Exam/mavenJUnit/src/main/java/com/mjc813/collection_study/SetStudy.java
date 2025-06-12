package com.mjc813.collection_study;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetStudy {
    public static void main(String[] args) {
        Set<String> ss = new HashSet<>();
        ss.add("hi");
        ss.add("hello");
        ss.add("java");
        ss.add("spring");
        ss.add("world");
        Iterator<String> is = ss.iterator();

        System.out.println(ss.size());

        while (is.hasNext()) {
            String s = is.next();
            System.out.print(s + " ");

        }

        System.out.println();

        ss.remove("hi");
        for (String s : ss) {
            System.out.print(s+" ");
        }

    }
}
