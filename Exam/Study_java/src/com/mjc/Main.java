package com.mjc;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        byte bt = Byte.parseByte("12");
        long ln = Long.parseLong("64");
        float fl = Float.parseFloat("12.3f");
        String strBt = String.valueOf(bt);
        String strln = String.valueOf(ln);
        String strfl = String.valueOf(fl);

        Scanner scanner = new Scanner(System.in);
        float f = 10.0f;

        System.out.println(f);
        System.out.println(ln);
        System.out.println(fl);
        System.out.println(strBt);
        System.out.println(strln);
        System.out.println(strfl);
    }

}
