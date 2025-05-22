package com.mjc.studyjava;

public class Bird extends Animal{
    private String wings = "날개";

    public String getWings() {
        return wings;
    }

    public void setWings(String wings) {
        this.wings = wings;
    }

    public Bird(String name){
        super(name);
    }

    void flap(){
        System.out.println(getName() + wings + "날개짓한다.");
    }
    void fly(){
        System.out.println(getName() + wings + "난다.");
    }
    @Override
    Animal reproduce(String newName){
        return new Bird(newName);
    }
}
//com.mjc813.studyjava.Bird 클래스 는 Animal 클래스를 상속받는다.
//멤버변수 : String wings ("날개")
//멤버메소드 : void flap() {출력 "{이름} {날개} 날개짓한다."}
//void fly() {출력 "{이름} {날개} 난다."}
//부모의 reproduce 를 재정의 해서 return Bird 객체가 되도록 한다.

