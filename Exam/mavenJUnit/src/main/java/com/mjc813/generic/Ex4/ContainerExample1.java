package com.mjc813.generic.Ex4;

public class ContainerExample1 {
    public static void main(String[] args) {
        Container1<String> container1 = new Container1<>();
        container1.set("홍길동");
        System.out.println("container1.get() = " + container1.get());

        Container1<Integer> container2 = new Container1<>();
        container2.set(100);
        System.out.println("container2.get() = " + container2.get());
    }
}
