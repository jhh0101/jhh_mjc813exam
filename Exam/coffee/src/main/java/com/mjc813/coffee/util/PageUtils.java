package com.mjc813.coffee.util;

import java.util.ArrayList;
import java.util.List;
import com.mjc813.coffee.dto.PagingDto;
import com.mjc813.coffee.dto.PageInfoDto;

public class PageUtils {

    public static PageInfoDto getPageInfo(PagingDto pagingDto, int totalCount) {
        int rows = pagingDto.getRows();
        int currentPage = pagingDto.getPage();

        if (rows < 1 || currentPage < 1) {
            rows = 5;
            currentPage = 1;
            pagingDto.setRows(rows);
            pagingDto.setPage(currentPage);
        }

        int totalPage = (int) Math.ceil((double) totalCount / rows);
        int prev = currentPage > 1 ? currentPage - 1 : 1;
        int next = currentPage < totalPage ? currentPage + 1 : totalPage;

        List<Integer> pageNum = new ArrayList<>();
        for (int i = 1; i <= totalPage; i++) {
            pageNum.add(i);
        }

        return new PageInfoDto(prev, next, totalPage, pageNum);
    }
}
