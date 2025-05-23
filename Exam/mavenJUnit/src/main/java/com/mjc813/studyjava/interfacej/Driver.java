package com.mjc813.studyjava.interfacej;

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
        if(ivehicle instanceof Truck){
            Truck truck = (Truck) ivehicle;
            System.out.println("운전수"+this.name+"은 "+truck.drive());
        }
        if(ivehicle instanceof Bicycle){
            Bicycle bicycle = (Bicycle) ivehicle;
            System.out.println("운전수"+this.name+"은 "+bicycle.drive());
        }
    }

    void breakk(){
        if(ivehicle instanceof Truck truck) {
            System.out.println("운전수" + this.name + "은 "+truck.breakk());
        }
        if(ivehicle instanceof Bicycle bicycle) {
            System.out.println("운전수" + this.name + "은 "+bicycle.breakk());
        }
    }
}
