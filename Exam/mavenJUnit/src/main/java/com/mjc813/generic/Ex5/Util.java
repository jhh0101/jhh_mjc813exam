package com.mjc813.generic.Ex5;

public class Util {
    public static <K, V, T extends Pair<K, V>> V getValue(T type, K key){
        if(type.getKey().equals(key)){
            return type.getValue();
        }
        return null;
    }
}
