package com.mjc813.studyjava.abstractj;

public abstract class Vehicle {
    int wheelCount;
    abstract void move();
    abstract void stop();


}
//com.mjc813.studyjava.abstractj.Vehicle 추상클래스를 만든다.
//        멤버변수 : int wheelCount;  => 바퀴갯수
//추상메소드 : void move();
//void stop();

//com.mjc813.studyjava.abstractj.Bicycle 클래스를 Vehicle 추상클래스를 상속받는다.
//        멤버변수 : String name;
//com.mjc813.studyjava.abstractj.Driver 운전수 클래스를 만든다.
//멤버변수 : String name, int age, Vehicle vehicle
//생성자 : 이름, 나이, Vehicle클래스 인스턴스객체
//멤버메소드 : void drive(); => Vehicle클래스 인스턴스객체가 Truck 을 운전할때에는
//					"운전수{이름}은 {wheelCount}개의 바퀴의 트럭{이름}을 운전한다." 출력한다.
//Vehicle클래스 인스턴스객체가 Bicycle 을 운전할때에는
//					"운전수{이름}은 {wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 출력한다.
//void break(); => "운전수{이름}은 트럭/자전거{이름}을 정지한다." 출력한다.


//3.
//        - /doc/mjc813.zip 파일을 본인 컴퓨터의 C:\Users\사용자명\.m2\repository\com 에 압축 풀으세요
//- 압축풀면 "C:\Users\사용자명\.m2\repository\com\mjc813\mjc_library\1.0-SNAPSHOT\mjc_library-1.0-SNAPSHOT.jar" 파일이 있어야 합니다.
//- Java 프로젝트를 Maven 프로젝트인지 확인하세요. 즉 프로젝트의 루트 디렉토리에 pom.xml 파일이 있어야 합니다.
//        - pom.xml 의 <dependencies> ~ </dependencies> 안에 아래의 문장을 붙여넣기 하세요
//
//        <dependencies>
//		...
//		<dependency>
//		  <groupId>com.mjc813</groupId>
//		  <artifactId>mjc_library</artifactId>
//		  <version>1.0-SNAPSHOT</version>
//		</dependency>
//	</dependencies>
//        - com.mjc813.mjc_library.IMarketInfo 인터페이스를 구현하는 클래스를 만드세요.
//- com.mjc813.mjc_library.MjcPoint 클래스를 public static void main 안에서 인스턴스하고
//addPoint 와 subPoint 메소드를 실행하세요.