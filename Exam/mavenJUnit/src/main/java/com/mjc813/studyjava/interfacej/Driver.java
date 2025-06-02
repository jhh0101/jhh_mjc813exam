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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public IVehicle getIvehicle() {
        return ivehicle;
    }

    public void setIvehicle(IVehicle ivehicle) {
        this.ivehicle = ivehicle;
    }

    void drive(){
        System.out.println("운전수 "+this.getName()+"은 "+getIvehicle().drive());
    }

    void breakk(){
        System.out.println("운전수 " + this.getName() + "은 "+getIvehicle().breakk());
    }
}
