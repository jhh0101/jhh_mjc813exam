package com.mjc813.computer;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class Computer implements Comparable<Computer> {
    private String name;
    private ECpu cpu;
    private ERam ram;
    private EStorage storage;
    private EGraphicCard graphicCard;
    private Mouse mouse = new Mouse();
    private Integer price;
    private Integer qty;

    public Computer() {
        this("Computer", null, null, null, null, null, null);
    }
    public Computer( String name ) {
        this(name, null, null, null, null, null, null);
    }
    public Computer( String name, ECpu cpu ) {
        this(name, cpu, null, null, null, null, null);
    }
    public Computer( String name, ECpu cpu, ERam ram ) {
        this(name, cpu, ram, null, null, null, null);
    }
    public Computer( String name, ECpu cpu, ERam ram, EStorage storage ) {
        this(name, cpu, ram, storage, null, null, null);
    }
    public Computer( String name, ECpu cpu, ERam ram, EStorage stor, EGraphicCard graphic, Integer price, Integer qty) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = stor;
        this.graphicCard = graphic;
        this.price = price;
        this.qty = qty;
    }
    public void print() {
        System.out.printf("이름 : %s\n", this.name);
        System.out.printf("CPU : %s\n", this.cpu == null ? "조립중입니다" : this.cpu);
        System.out.printf("RAM : %s\n", this.ram == null ? "조립중입니다" : this.ram);
        System.out.printf("Storage : %s\n", this.storage == null ? "조립중입니다" : this.storage);
        System.out.printf("Graphic : %s\n", this.graphicCard == null ? "조립중입니다" : this.graphicCard);
    }

    public void booting() {
        System.out.printf("%s 켜졌습니다.\n", this.name);
    }

    public void powerOff() {
        System.out.printf("%s 가 꺼집니다.\n", this.name);
    }

    public void clickMouseLeftButton(int x, int y) {
        this.mouse.moveMouse(x, y);
        this.mouse.clickLeftButton();
    }

    public void clickMouseRightButton(int x, int y) {
        this.mouse.moveMouse(x, y);
        this.mouse.clickRightButton();
    }

    @Override
    public String toString() {
        return "이름 : " + name + ", cpu : " + cpu + ", ram : " + ram + ", storage : " + storage + ", graphicCard : " + graphicCard;
    }

    @Override
    public int compareTo(Computer o) {
        return this.cpu.compareTo(o.getCpu());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(name, computer.name) && cpu == computer.cpu && ram == computer.ram && storage == computer.storage && graphicCard == computer.graphicCard && Objects.equals(mouse, computer.mouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpu, ram, storage, graphicCard, mouse);
    }

//- Computer 클래스 객체 배열을 생성하고 배열 원소 5개 이상 추가한다. 비기본생성자를 통하여 price 와 qty 는 임의의 정수를 저장하세요
//- 객체배열의 stream() 을 이용하여 Computer 객체의 재고 총 금액을 계산하세요. 모든 배열 원소들의 price * qty 의 합계금액이다.
//- 객체배열의 stream() 을 이용하여 cpu 가 가장 낮은 Computer 객체의 재고 수량이 몇개인지 계산하세요
//- 6월2일 문제 풀은것을 계속 활용한다.
//- Contact 클래스에 Integer age 멤버변수를 추가한다.
//            - Contact 클래스 객체배열을 생성하고 배열 원소 5개 이상 추가한다. age 값도 생성자에서 저장되도록 추가한다.
//- 객체배열의 stream() 을 이용하여 연락처 사람의 평균 나이를 계산한다.
}