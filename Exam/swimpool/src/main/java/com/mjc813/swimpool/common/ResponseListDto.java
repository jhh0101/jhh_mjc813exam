package com.mjc813.swimpool.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseListDto {
    private Integer totalPage;
    private Integer rowsPage;
    private Integer curPage;
    private Object data;


}
