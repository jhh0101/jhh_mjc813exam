package com.mjc813.computer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Computer {
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


}