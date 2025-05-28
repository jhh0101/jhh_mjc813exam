package com.mjc813.studyjava.interfacej;

public interface IVehicle {

    String drive();
    String breakk();
}
//2. 인터페이스를 활용
//com.mjc813.studyjava.interfacej.IVehicle 인터페이스를 만든다.
//        추상메소드 : String drive();
//String breakk();
//
//com.mjc813.studyjava.interfacej.ITruck 인터페이스는 IVehicle 인터페이스를 상속받는다.
//com.mjc813.studyjava.interfacej.Truck 클래스는 IVehicle 인터페이스를 구현 한다.
//멤버변수 : String name, int wheelCount;
//생성자 : 필요하다
//멤버메소드 : String drive();	=> "{wheelCount}개의 바퀴의 트럭{이름}을 운전한다." 문자열 리턴
//String breakk();	=> "트럭{이름}을 정지한다." 문자열 리턴
//
//com.mjc813.studyjava.interfacej.IBicycle 인터페이스는 IVehicle 인터페이스를 상속받는다.
//com.mjc813.studyjava.interfacej.Bicycle 클래스는 IBicycle 인터페이스를 구현 한다.
//멤버변수 : String name, int wheelCount;
//생성자 : 필요하다
//멤버메소드 : String move();	=> "{wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 문자열 리턴
//String breakk();	=> "자전거{이름}을 정지한다." 문자열 리턴
//
//com.mjc813.studyjava.interfacej.Driver 운전수 클래스를 만든다.
//멤버변수 : String name, int age, IVehicle ivehicle
//생성자 : 이름, 나이, IVehicle구현클래스 인스턴스객체
//멤버메소드 : void drive(); => Vehicle클래스데이터형 이 Truck 을 운전할때에는
//					"운전수{이름}은 {wheelCount}개의 바퀴의 트럭{이름}을 운전한다." 출력한다.
//Vehicle클래스데이터형 이 Bicycle 을 운전할때에는
//					"운전수{이름}은 {wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 출력한다.
//void breakk(); => "운전수{이름}은 트럭/자전거{이름}을 정지한다." 출력한다.


// 오버라이드 > 부모 메서드의 타입, 매개변수, 메서드명이 같은 메서드를 자식클래스에서 재정의 해주는 것
// 오버라이드란 상속관계에서 같은 메서드 시그니처를 가진 동일 메서드를 재정의 하는것