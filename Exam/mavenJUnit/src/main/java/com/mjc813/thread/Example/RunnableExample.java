package com.mjc813.thread.Example;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hi");
        }
    }
}
