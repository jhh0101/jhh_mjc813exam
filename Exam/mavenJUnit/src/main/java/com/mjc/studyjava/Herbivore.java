package com.mjc.studyjava;

public class Herbivore extends Mammalia{
    public Herbivore(String name) {
        super(name);
    }

    @Override
    Animal reproduce(String name){
        return new Herbivore(name);
    }
}
//com.mjc813.studyjava.Herbivore 클래스 는 Mammalia 클래스를 상속받는다.
//멤버메소드 : 부모의 reproduce 를 재정의 해서 return Herbivore 객체가 되도록 한다.
