package com.mjc.studyjava;

public class Mammalia extends Animal {

    public Mammalia(String name) {
        super(name);
    }

    void feedingMilk(){
        System.out.println(getName() + "젖을 먹인다.");
    }

    @Override
    void eat(Object feed){
        if(feed instanceof String newFeed) {
            System.out.println(getName() + "은 " + newFeed + "를 먹는다.");
        }
    }

    @Override
    Animal reproduce(String name){
        return new Mammalia(name);
    }
}
//com.mjc813.studyjava.Mammalia 클래스 는 Animal 클래스를 상속받는다.
//멤버메소드 : void feedingMilk() {출력 "{이름} 젖을 먹인다.}
//eat 메소드를 재정의 하여서 매개변수에는 String 데이터형태만 입력되어서 "{이름}은 {음식이름}를 먹는다"로 출력하도록 재정의한다.
//부모의 reproduce 를 재정의 해서 return Mammalia 객체가 되도록 한다.
