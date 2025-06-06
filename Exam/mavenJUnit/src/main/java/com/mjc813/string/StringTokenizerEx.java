package com.mjc813.string;

import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");
        for(String token : arr){
            System.out.println(token);
        }
        System.out.println();

        String data2 = "홍길동/이수홍&박연수,김철수";
        StringTokenizer st = new StringTokenizer(data2, "/|,|&");
        while (st.hasMoreTokens()){
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
