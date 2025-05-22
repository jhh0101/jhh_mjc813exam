package com.mjc813.studyjava.abstractj;

public class Driver{

    private String name;
    private int age;
    private Vehicle vehicle;

    public void Driver(String name, int age, Vehicle vehicle){
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }
    void drive(){
        if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle;
            System.out.println("운전수"+this.name+"은 "+truck.getTon()+"개의 바퀴의 트럭"+truck.getName()+"을 운전한다.");
        }
        if (vehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) vehicle;
            System.out.println("운전수" + this.name + "은 " + bicycle.wheelCount + "개의 바퀴의 자전거" + bicycle.getName() + "을 이동한다.");
        }
    }
    public void breakk(){
        if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle;
            System.out.println("운전수"+this.name+"은 트럭/자전거"+truck.getName()+"을 정지한다.");
        }
        if (vehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) vehicle;
            System.out.println("운전수" + this.name + "은 트럭/자전거" + bicycle.getName() + "을 정지한다.");
        }
    }

}
//생성자 : 이름, 나이, Vehicle클래스 인스턴스객체