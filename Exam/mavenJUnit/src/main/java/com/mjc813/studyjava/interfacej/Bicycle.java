package com.mjc813.studyjava.interfacej;


import lombok.Data;

@Data
public class Bicycle implements IBicycle{

    private String name;
    private int wheelCount;


    public Bicycle(String name, int wheelCount){
        this.name = name;
        this.wheelCount = wheelCount;
    }

    @Override
    public String drive() {
        return this.getWheelCount()+"개의 바퀴의 자전거 "+this.getName()+"을 운전한다.";
    }

    @Override
    public String breakk() {
        return "자전거 "+this.getName()+ "을 정지한다.";
    }
}
