package com.mjc813.thread.Ex2;

public class MovieThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("동영상을 재생합니다.");
            if(Thread.interrupted()){
                System.out.println("동영상을 종료합니다.");
                break;
            }
        }
    }
}
