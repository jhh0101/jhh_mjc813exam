package com.mjc813.computer;

import java.util.Comparator;

public class ComputerComparator implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o2.getRam().compareTo(o1.getRam());
    }
}
