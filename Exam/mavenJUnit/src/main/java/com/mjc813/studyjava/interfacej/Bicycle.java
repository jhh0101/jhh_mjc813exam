package com.mjc813.studyjava.interfacej;

public class Bicycle implements IBicycle{

    private String name;
    private int wheelCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public Bicycle(String name, int wheelCount){
        this.name = name;
        this.wheelCount = wheelCount;
    }

    @Override
    public String drive() {
        return this.wheelCount+"개의 바퀴의 자전거"+this.name+"을 운전한다.";
    }

    @Override
    public String breakk() {
        return "자전거"+this.name+"을 정지한다.";
    }
}
