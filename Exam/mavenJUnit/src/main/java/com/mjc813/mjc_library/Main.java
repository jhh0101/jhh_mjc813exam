//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mjc813.mjc_library;


public class Main {
    public static void main(String[] args) {
        MjcPoint mp = new MjcPoint();
        mp.getMarketPoint();
        mp.addPoint((IMarketInfo)null, 10);
        mp.addPoint(new SampleMarketInfo(), 50);
        mp.subPoint((IMarketInfo)null, 20);
        mp.subPoint(new SampleMarketInfo(), 20);
    }
}
