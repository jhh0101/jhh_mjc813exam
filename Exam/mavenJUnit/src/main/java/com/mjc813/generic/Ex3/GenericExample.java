package com.mjc813.generic.Ex3;

public class GenericExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.content = "123";

        Box<String> box2 = new Box<>();
        box2.content = "123";
        boolean result = box1.compare(box2);

        System.out.println(result);

    }

}
