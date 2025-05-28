package com.mjc.studyjava;

public class Animal {
    private String name;
    private int age;

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

    public Animal(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    void eat(Object feed){
        System.out.println(name + "은 " + feed + "를 먹는다");
    }

    void sleep(){
        System.out.println(name + "잔다");
    }

    void move(){
        System.out.println(name + "이동한다");
    }
    Animal reproduce(String newName){
        Animal animal = new Animal(newName);
        return animal;
    }
}


//com.mjc813.studyjava.Animal 클래스
//멤버변수 : String name, int age
//멤버메소드 : void eat(Object feed) {출력 "{이름}은 {feed}를 먹는다"}
//void sleep() {출력 "{이름} 잔다"}
//void move() {출력 "{이름} 이동한다"}
//Animal reproduce(String newName) {Animal 객체의 이름을 정해서 생성하고 리턴한다}



//
//Main 에서 Animal, Bird, Parrot, Eagle, Mammalia, Herbivore, Carnivore 객체를 하나 이상씩 만들어서
//각각의 메소드를 실행하고 출력 해 보세요 (정답이 없습니다.)
//특히 reproduce 메소드를 실행하여 객체를 직접 낳는 실행을 해보고, 그 객체가 인스턴스됐는지 아무 메소드나 실행해 보세요.