package com.mjc813.computer;

import java.util.Arrays;

public class ComputerMain{
    public static void main(String[] args) {
        Computer[] coms = new Computer[5];

        for( int i = 0; i < coms.length; i++ ) {
            coms[i] = new Computer();
            coms[i].setName("com " + i+1);
            coms[i].setCpu(ECpu.Gen9_i5);
            coms[i].setRam(ERam.RAM_8GB);
            coms[i].setStorage(EStorage.SSD_500GB);
            coms[i].setGraphicCard(EGraphicCard.Intel_A770);
        }
        System.out.println(Arrays.toString(coms));
        Arrays.sort(coms, new ComputerComparator());
        System.out.println(Arrays.toString(coms));
        for( Computer com : coms ) {
            com.booting();
            com.print();
            com.powerOff();
            System.out.println(com.toString());
        }
    }
}
