package com.mjc813.studyjava.interfacej;

public class DriverMain {
    public static void main(String[] args) {
        Truck truck = new Truck("볼보", 4);
        Bicycle bicycle = new Bicycle("삼천리", 2);
        Driver driver1 = new Driver("쿠팡맨", 50, truck);
        Driver driver2 = new Driver("엄복동", 18, bicycle);
        driver1.drive();
        driver1.breakk();
        driver2.drive();
        driver2.breakk();
    }
}
