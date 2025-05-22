package com.mjc.studyjava;

public class Parrot extends Bird{

    public Parrot(String name) {
        super(name);
    }

    @Override
    void fly() {
        System.out.println(getName() + getWings() + "조금만 난다.");
    }

    @Override
    void eat(Object feed){
        if (feed instanceof String newFeed){
            System.out.println(getName() + "은 " + newFeed + "를 먹는다" );
        }
    }

    @Override
    Parrot reproduce(String name){
        Parrot parrot = new Parrot(name);
        return parrot;
    }
}

//
//com.mjc813.studyjava.Parrot 클래스 는 Bird 클래스를 상속받는다.
//멤버메소드 : fly 메소드를 재정의 하여서 {출력 "{이름} {날개} 조금만 난다."}
//eat 메소드를 재정의 하여서 매개변수에는 String 데이터형태만 입력되어서 "{이름}은 {곡식이름}를 먹는다"로 출력하도록 재정의한다.
//부모의 reproduce 를 재정의 해서 return Parrot 객체가 되도록 한다.