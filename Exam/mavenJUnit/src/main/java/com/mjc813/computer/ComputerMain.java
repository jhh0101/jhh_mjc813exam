package com.mjc813.computer;

import java.util.*;
import java.util.stream.IntStream;

public class ComputerMain{
    public static void main(String[] args) {
        List<Computer> coms = new ArrayList<>();
        HashSet<Computer> hsComputer = new HashSet<>();
        TreeSet<Computer> computerTreeSet = new TreeSet<>(new ComputerComparator());

//        computerTreeSet.add(new Computer("com 111", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080));
//        computerTreeSet.add(new Computer("com 112", ECpu.Gen9_i5, ERam.RAM_4GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770));
//        computerTreeSet.add(new Computer("com 113", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_500GB, EGraphicCard.GTX_1660));
//        computerTreeSet.add(new Computer("com 114", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.SSD_1000GB, EGraphicCard.RTX_4080));
//
//        for (Computer c : computerTreeSet) {
//            System.out.println(c);
//        }


//        hsComputer.add(new Computer("com 111", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080));
//        hsComputer.add(new Computer("com 112", ECpu.Gen9_i5, ERam.RAM_4GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770));
//        hsComputer.add(new Computer("com 113", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_500GB, EGraphicCard.GTX_1660));
//        hsComputer.add(new Computer("com 114", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.SSD_1000GB, EGraphicCard.RTX_4080));
//
//        for (Computer c : hsComputer) {
//            System.out.println(c);
//        }
//
        coms.add(new Computer("com 123", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080, 1500000, 5));
        coms.add(new Computer("com 234", ECpu.Gen9_i5, ERam.RAM_16GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770, 1000000, 3));
        coms.add(new Computer("com 345", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_500GB, EGraphicCard.RTX_4080, 1100000, 2));
        coms.add(new Computer("com 456", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.SSD_2000GB, EGraphicCard.GTX_1660, 100000, 7));
        coms.add(new Computer("com 567", ECpu.Gen9_i7, ERam.RAM_4GB, EStorage.SSD_1000GB, EGraphicCard.Intel_A770, 400000, 6));

        int comSum = coms.stream()
                .mapToInt(com -> com.getPrice() * com.getQty())
                .sum();

        int comQty = coms.stream()
                .filter(com -> com.getCpu().equals(ECpu.Gen9_i5))
                .mapToInt(Computer::getQty)
                .sum();

        System.out.println("가장 낮은 CPU 재고 수 : " + comQty + "개");
        System.out.println("재고 총 금액 : " + comSum + "원");
//        for( Computer com : coms ) {
//            com.booting();
//            com.print();
//            com.powerOff();
//            System.out.println(com.toString());
//        }
    }
}
