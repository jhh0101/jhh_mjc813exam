package com.mjc813.thread;

public class SumThread extends Thread{
    private long sum;

    public long setSum(long sum){
        return this.sum = sum;
    }

    public long getSum(){
        return this.sum;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            sum += i;
        }
    }
}
