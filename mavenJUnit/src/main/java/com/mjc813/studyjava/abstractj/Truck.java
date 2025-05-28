package com.mjc813.studyjava.abstractj;

public class Truck extends Vehicle{
    private String name;
    private int ton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTon() {
        return ton;
    }

    public void setTon(int ton) {
        this.ton = ton;
    }

    @Override
    void move() {

    }

    @Override
    void stop() {

    }
}
//com.mjc813.studyjava.abstractj.Truck 클래스를 Vehicle 추상클래스를 상속받는다.
//        멤버변수 : Sting name, int ton;