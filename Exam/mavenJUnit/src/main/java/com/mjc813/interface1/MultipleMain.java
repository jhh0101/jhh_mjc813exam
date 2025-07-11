package com.mjc813.interface1;

public class MultipleMain {
    public static void main(String[] args) {
        Thread t = new Thread(new multiplePrint(2));
        t.start();
    }
}
