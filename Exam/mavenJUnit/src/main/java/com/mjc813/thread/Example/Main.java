package com.mjc813.thread.Example;

public class Main {
    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        Thread thread1 = new Thread(new RunnableExample());

        thread.start();
        thread1.start();
    }
}
