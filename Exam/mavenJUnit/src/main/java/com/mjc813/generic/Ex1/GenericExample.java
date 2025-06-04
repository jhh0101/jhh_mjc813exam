package com.mjc813.generic.Ex1;

public class GenericExample {
    public static void main(String[] args) {
        Box<String> str1 = new Box<>();
        str1.content = "안녕하세요";
        String text = str1.content;
        System.out.println(text);

        Box<Integer> str2 = new Box<>();
        str2.content = 100;
        int num = str2.content;
        System.out.println(num);

        Product<Tv, String> product1 = new Product<>();
        product1.setKind(new Tv());
        product1.setModel("스마트 Tv");

        Tv tv = new Tv();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV 자동차");

        Car car = new Car();
        String carModel = product2.getModel();

        System.out.println(tvModel);
        System.out.println(carModel);
    }
}
