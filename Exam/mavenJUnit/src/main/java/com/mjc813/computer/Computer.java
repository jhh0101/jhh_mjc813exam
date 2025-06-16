package com.mjc813.computer;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Computer implements Comparable<Computer> {
    private String name;
    private ECpu cpu;
    private ERam ram;
    private EStorage storage;
    private EGraphicCard graphicCard;
    private Mouse mouse = new Mouse();

    public Computer() {
        this("Computer", null, null, null, null);
    }
    public Computer( String name ) {
        this(name, null, null, null, null);
    }
    public Computer( String name, ECpu cpu ) {
        this(name, cpu, null, null, null);
    }
    public Computer( String name, ECpu cpu, ERam ram ) {
        this(name, cpu, ram, null, null);
    }
    public Computer( String name, ECpu cpu, ERam ram, EStorage storage ) {
        this(name, cpu, ram, storage, null);
    }
    public Computer( String name, ECpu cpu, ERam ram, EStorage stor, EGraphicCard graphic ) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = stor;
        this.graphicCard = graphic;
    }
    public void print() {
        System.out.printf("이름 : %s\n", this.name);
        System.out.printf("CPU : %s\n", this.cpu == null ? "조립중입니다" : this.cpu);
        System.out.printf("RAM : %s\n", this.ram == null ? "조립중입니다" : this.ram);
        System.out.printf("Storage : %s\n", this.storage == null ? "조립중입니다" : this.storage);
        System.out.printf("Graphic : %s\n", this.graphicCard == null ? "조립중입니다" : this.graphicCard);
//        CPU : Gen9_i7
//        RAM : 16GB
//        Storage : HDD 500GB
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
    public boolean equals(Object o) {
        return o == cpu && o == ram && o == storage && o == graphicCard;
    }

    @Override
    public String toString() {
        return "이름 : " + name + ", cpu : " + cpu + ", ram : " + ram + ", storage : " + storage + ", graphicCard : " + graphicCard;
    }

    @Override
    public int compareTo(Computer o) {
        return this.cpu.compareTo(o.getCpu());
    }

//    compareTo 와 compare 메소드를 오버라이드 재정의 한다.
//    compareTo 메소드는 cpu 멤버변수의 성능이 작다, 같다, 크다로 구분하는 기능을 구현한다.
//    compare 메소드는 ram 멤버변수의 크기가 작다, 같다, 크다로 구분하는 기능을 구현한다.
//15장의 예제들을 본인이 직접 소스 개발 해보세요. (클래스를 별도로 만들필요 없이 Chapter15 클래스의 메소드로 추가해도된다.)
//            15장의 확인문제 소스를 직접 풀어보세요.
//6월13일 문제의 Computer 클래스를 HashSet 에 저장할때 키를 무엇으로 할지 결정하고 저장해보세요
//6월13일 문제의 Computer 클래스를 TreeMap 에 5월16일 자료를 저장할때 자동으로 정렬되는것을 확인해보세요.
}