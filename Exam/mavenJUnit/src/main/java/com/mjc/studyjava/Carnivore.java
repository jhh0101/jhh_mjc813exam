package com.mjc.studyjava;

public class Carnivore extends Mammalia{
    public Carnivore(String name) {
        super(name);
    }

    @Override
    void eat(Object feed){
        if(feed instanceof Herbivore newFeed){
            System.out.println(getName() + "은 " + newFeed + "를 먹는다.");
        }
    }

    @Override
    Animal reproduce(String name){
        return new Carnivore(name);
    }
}
//com.mjc813.studyjava.Carnivore 클래스 는 Mammalia 클래스를 상속받는다.
//멤버메소드 : eat 메소드를 재정의 하여서 매개변수에는 Herbivore 데이터형태만 입력되어서 "{이름}은 {초식동물이름}를 먹는다"로 출력하도록 재정의한다.
//부모의 reproduce 를 재정의 해서 return Carnivore 객체가 되도록 한다.
