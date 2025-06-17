package com.mjc813.ramda;

import java.util.ArrayList;
import java.util.List;

public class Process {
    private String s;
    private Integer i;
    private List<Integer> l;

    public Process(String s, Integer i){
        this.s = s;
        this.i = i;
    }
    public Process(List<Integer> l){
        this.l = l;
    }
    public void printString(INumberProc inp){
        inp.process(s, i);
    }
    public void number(IArrayProc iap){
        iap.process(l);
    }
    public static Long sum(List<Integer> list) {
        Long sum = 0L;
        for (Integer i : list) {
            sum += i;
        }
        System.out.printf("합은 {%d} 입니다.\n", sum);
        return sum;
    }
    public static Long avg(List<Integer> list) {
        Long sum = sum(list);
        Long avg = sum / list.size();
        System.out.printf("평균은 {%d} 입니다.\n", avg);
        return avg;
    }


}
//문제1
//public interface INumberProc {
//    public void process(String str, Integer age);
//}
//process 를 람다식을 만들어서 호출하는
//str 변수와 age 변수의 내용을 아래와 같이 출력하는 메소드
//	"{str} 님의 나이는 {age} 입니다."
//printHuman(INumberProc inp) {
//    inp.process( .... );
//}
//printHuman(.......);
//문제2
//str 변수와 age 변수의 내용을 아래와 같이 출력하는 메소드
//	"자동자 {str} 의 년식은 {age} 입니다."
//printCar(INumberProc inp) {
//    inp.process( .... );
//}
//printCar(.......);
//문제3
//public interface IArrayProc {
//    public Long process(List<Integer> list);
//}
//list 배열의 합을 리턴하는 기능
//void sum() {
//    Long sum = 0;
//		....
//    System.out.printf("합은 {%d} 입니다.", sum);
//}
//문제4
//list 배열의 합을 리턴하는 기능
//void avg() {
//    Long avg = 0;
//		....
//    System.out.printf("평균은 {%d} 입니다.", avg);
//}