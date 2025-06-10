package com.mjc813.thread;

public class YieldExample {
    public static void main(String[] args) {
        WorkThread work1 = new WorkThread("Thread A");
        WorkThread work2 = new WorkThread("Thread B");

        work1.start();
        work2.start();

        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        work1.work = false;
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        work1.work = true;
    }
}
