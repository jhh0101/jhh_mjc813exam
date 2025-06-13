package com.mjc813.generic.Ex6;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);

        arr2.add("Java");
        arr2.add("Hello");
        arr2.add("World");
        arr2.add("Spring");

        printArr(arr1);
        printArr(arr2);
    }
    public static void printArr(ArrayList<?> list){
        System.out.println(list);
    }
}
