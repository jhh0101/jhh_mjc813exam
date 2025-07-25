package com.mjc813.coffee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageInfoDto {
    private int prev;
    private int next;
    private int totalPage;
    private List<Integer> pageNum;
}
