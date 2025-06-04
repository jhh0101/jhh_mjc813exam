package com.mjc813.generic.Ex4;



public class Container1<T> {
    private T value;
    public void set(T value){
        this.value = value;
    }
    public T get(){
        return this.value;
    }
}
