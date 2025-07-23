package com.mjc813.contact_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingDto {
    private Integer rows;
    private Integer page;
    private Integer off;
    private boolean hasNext;
    private boolean hasPrev;
    private int nextPage;
    private int prevPage;
    private Integer num;


    private List<PageItem> pages;

    public PagingDto(int totalItems, int currentPage, int pageSize) {
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.pages = new ArrayList<>();

        for (int i = 1; i <= totalPages; i++) {
            pages.add(new PageItem(i, i == currentPage));
        }

        this.hasPrev = currentPage > 1;
        this.hasNext = currentPage < totalPages;
        this.prevPage = hasPrev ? currentPage - 1 : 1;
        this.nextPage = hasNext ? currentPage + 1 : totalPages;
    }

    // Getters and setters 생략

    public static class PageItem {
        private int num;
        private boolean isCurrent;

        public PageItem(int num, boolean isCurrent) {
            this.num = num;
            this.isCurrent = isCurrent;
        }

        public int getNum() {
            return num;
        }

        public boolean isIsCurrent() {
            return isCurrent;
        }
    }

}
