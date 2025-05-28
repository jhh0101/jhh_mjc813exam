package com.mjc.studyjava;

public class AnimalMain {
    public static void main(String[] args) {
        Animal animal = new Animal("동물 이름");
        Bird bird = new Bird("새");
        Parrot parrot = new Parrot("앵무새");
        Eagle eagle = new Eagle("독수리");
        Mammalia mammalia = new Mammalia("포유류");
        Herbivore herbivore = new Herbivore("초식 동물");
        Carnivore carnivore = new Carnivore("육식 동물");

        animal.move();
        bird.fly();
        eagle.fly();
        parrot.fly();
        mammalia.eat("풀때기");
        Animal monkey = herbivore.reproduce("원숭이");
        carnivore.eat(monkey);
    }
}
//Main 에서 Animal, Bird, Parrot, Eagle, Mammalia, Herbivore, Carnivore 객체를 하나 이상씩 만들어서
//각각의 메소드를 실행하고 출력 해 보세요 (정답이 없습니다.)
//특히 reproduce 메소드를 실행하여 객체를 직접 낳는 실행을 해보고, 그 객체가 인스턴스됐는지 아무 메소드나 실행해 보세요.
