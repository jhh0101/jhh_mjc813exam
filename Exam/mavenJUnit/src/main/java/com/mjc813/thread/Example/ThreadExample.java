package com.mjc813.thread.Example;

public class ThreadExample extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
