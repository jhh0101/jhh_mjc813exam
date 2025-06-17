package com.mjc813.computer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class ComputerMain{
    public static void main(String[] args) {
        Computer[] coms = new Computer[5];
        HashSet<Computer> hsComputer = new HashSet<>();
        TreeSet<Computer> computerTreeSet = new TreeSet<>(new ComputerComparator());

        computerTreeSet.add(new Computer("com 111", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080));
        computerTreeSet.add(new Computer("com 112", ECpu.Gen9_i5, ERam.RAM_4GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770));
        computerTreeSet.add(new Computer("com 113", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_500GB, EGraphicCard.GTX_1660));
        computerTreeSet.add(new Computer("com 114", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.SSD_1000GB, EGraphicCard.RTX_4080));

        for (Computer c : computerTreeSet) {
            System.out.println(c);
        }

        for( int i = 0; i < coms.length; i++ ) {
            coms[i] = new Computer();
            coms[i].setName("com " + i+1);
            coms[i].setCpu(ECpu.Gen9_i5);
            coms[i].setRam(ERam.RAM_8GB);
            coms[i].setStorage(EStorage.SSD_500GB);
            coms[i].setGraphicCard(EGraphicCard.Intel_A770);
        }

        hsComputer.add(new Computer("com 111", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080));
        hsComputer.add(new Computer("com 112", ECpu.Gen9_i5, ERam.RAM_4GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770));
        hsComputer.add(new Computer("com 113", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_500GB, EGraphicCard.GTX_1660));
        hsComputer.add(new Computer("com 114", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.SSD_1000GB, EGraphicCard.RTX_4080));

        for (Computer c : hsComputer) {
            System.out.println(c);
        }

        for( Computer com : coms ) {
            com.booting();
            com.print();
            com.powerOff();
            System.out.println(com.toString());
        }
    }
}
