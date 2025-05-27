package com.mjc813.studyjava.interfacej;


import lombok.Data;

@Data
public class Driver {
    private String name;
    private int age;
    private IVehicle ivehicle;

    public Driver(String name, int age, IVehicle ivehicle){
        this.name = name;
        this.age = age;
        this.ivehicle = ivehicle;
    }

    void drive(){
        System.out.println("운전수 "+this.getName()+"은 "+getIvehicle().drive());
    }

    void breakk(){
        System.out.println("운전수 " + this.getName() + "은 "+getIvehicle().breakk());
    }
}
