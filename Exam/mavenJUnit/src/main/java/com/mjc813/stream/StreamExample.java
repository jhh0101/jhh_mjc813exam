package com.mjc813.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product(i, "상품"+i, "멋진 회사"+i, (int)(10000*Math.random()));
            list.add(product);
        }
        list.forEach( System.out::println );
    }
}
