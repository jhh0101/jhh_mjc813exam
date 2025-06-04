package com.mjc813.generic.Ex4;

public class ContainerExample2 {
    public static void main(String[] args) {
        Container2<String, String > container1 = new Container2<>();
        container1.set("홍길동", " 도적");
        System.out.println("container1.getKey() = " + container1.getKey());
        System.out.println("container1.getValue() = " + container1.getValue());

        Container2<String , Integer> container2 = new Container2<>();
        container2.set("홍길동", 35);
        System.out.println("container2.getKey() = " + container2.getKey());
        System.out.println("container2.getValue() = " + container2.getValue());
    }
}
