package com.mjc813.interface1;

class multiplePrint extends IteratorPrint implements Runnable{
    private final int a;
    multiplePrint(int a){
        this.a = a;
    }

    @Override
    public void run() {
        int res;
        for (int i = 1; i <= 100000; i++) {
            if(i % a == 0){
                res = i;
                print(res);
            }
        }
    }

}