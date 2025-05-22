package com.mjc.studyjava;

public class Eagle extends Bird{

    public Eagle(String name) {
        super(name);
    }

    @Override
    void fly(){
        System.out.println(getName() + getWings() + "높이 난다.");
    }

    @Override
    void eat(Object feed) {
        if(feed instanceof String newFeed){
            System.out.println(getName() + "은 " + newFeed + "를 먹는다.");
        }
    }
    @Override
    Animal reproduce(String name){
        return new Eagle(name);
    }
}
//
//com.mjc813.studyjava.Eagle 클래스 는 Bird 클래스를 상속받는다.
//멤버메소드 : fly 메소드를 재정의 하여서 {출력 "{이름} {날개} 높이 난다."}
//eat 메소드를 재정의 하여서 매개변수에는 Animal 데이터형태만 입력되어서 "{이름}은 {동물이름}를 먹는다"로 출력하도록 재정의한다.
//부모의 reproduce 를 재정의 해서 return Eagle 객체가 되도록 한다.
//
