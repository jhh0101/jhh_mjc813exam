package com.mjc813.swimpool_app.swimpool.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimpoolDto {
    // DB 에 있는 swimpool_tbl 테이블의 컬럼 정보
    private Integer id;
    private String name;
    private Integer lanes;
    private String laneType;
    private String phoneNumber;
    private String addr;
}
