package com.mjc813.mpacrud.animal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private String searchType;
    private String searchWord;
    private Integer rowsOnePage;
    private Integer page;
    private Integer offset;

    public Integer getOffset(){
        return (this.getPage()-1) * this.getRowsOnePage();
    }
}
