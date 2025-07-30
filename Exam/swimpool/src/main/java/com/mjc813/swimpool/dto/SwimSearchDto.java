package com.mjc813.swimpool.dto;

import com.mjc813.swimpool.common.ResponseListDto;

public class SwimSearchDto {

    private ResponseListDto listDto;
    private Integer offSet;

    public Integer getOffSet() {
        return (listDto.getCurPage()-1) * listDto.getRowsPage();
    }
}
