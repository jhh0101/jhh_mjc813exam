package com.mjc.studyjava;

public class MyMathMathic {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public long mul(int a, int b){
        return a*b;
    }
    public int divM(int a, int b){
        return a/b;
    }
    public int divN(int a, int b){
        return a%b;
    }
    public boolean same(int a, int b){
        return a==b;
    }
    public boolean same(String a, String b){
        return a.equals(b);
    }
    public boolean notsame(int a, int b){
        return a!=b;
    }
    public boolean big(int a, int b){
        return a>b;
    }
    public boolean small(int a, int b){
        return a<b;
    }
    public int shiftLeft(int a, byte b){
        return a<<b;
    }
    public int shiftRight(int a, byte b){
        return a>>b;
    }
    public int shiftRight0(int a, byte b){
        return a>>>b;
    }
    public long square(int a, byte b){
        for (int i = 0; i < b; i++) {
            a *= a;
        }
        return a;
    }
    public int absolute(int a){
        return Math.abs(a);
    }
    public String toHex(int a){
        return Integer.toHexString(a);
    }
    public String toBin(int a){
        return Integer.toBinaryString(a);
    }
    public String toOct(int a){
        return Integer.toOctalString(a);
    }
    public int toDec(String a){
        return Integer.parseInt(a);
    }

}
//com.mjc.studyjava.MyMathMathic 클래스 생성
//상술연산 하는 멤버메소드 5개 생성
//int add(int a, int b) : 두수를 더한 결과 리턴
//int sub(int a, int b) : 두수를 뺀 결과 리턴
//long mul(int a, int b) : 두수를 곱한 결과 리턴
//int divM(int a, int b) : 두수를 나눈 몫 결과 리턴
//int divN(int a, int b) : 두수를 나눈 나머지 결과 리턴
//비교연산 하는 멤버메소드 4개 생성
//boolean same(int a, int b) : 두수가 같으면 true 리턴, 아니면 false
//boolean same(String a, String b) : 두 문자열이 같으면 true 리턴, 아니면 false
//boolean notsame(int a, int b) : 두수가 다르면 true 리턴, 아니면 false
//boolean big(int a, int b) : a가 b보다 크면 true 리턴, 아니면 false
//boolean small(int a, int b) : a가 b보다 작으면 true 리턴, 아니면 false
//기타연산 하는 멤버메소드
//int shiftLeft(int a, byte b) : a를 b 만큼 왼쪽 시프트 결과 값을 리턴
//int shiftRight(int a, byte b) : a를 b 만큼 오른쪽 시프트(부호유지) 결과 값을 리턴
//int shiftRight0(int a, byte b) : a를 b 만큼 오른쪽 시프트(부호를0으로) 결과 값을 리턴
//long square(int a, byte b) : a를 b만큼 제곱한 결과 값을 리턴, *= 이용하여 코딩하세요
//int absolute(int a) : a의 절대값을 리턴
//String toHex(int a) : a 값을 16진수 문자열로 리턴
//String toBin(int a) : a 값을 2진수 문자열로 리턴
//String toOct(int a) : a 값을 8진수 문자열로 리턴
//int toDec(String a) : a 문자열을 10진수 정수로 리턴