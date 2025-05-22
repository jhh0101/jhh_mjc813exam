package com.mjc813.studyjava.interfacej;

public class Driver {
    private String name;
    private int age;
    private IVehicle ivehicle;

    void Driver(String name, int age, IVehicle ivehicle){

    }
    void drive(){
        if(ivehicle instanceof Truck){
            Truck truck = (Truck) ivehicle;
        }
    }
}
