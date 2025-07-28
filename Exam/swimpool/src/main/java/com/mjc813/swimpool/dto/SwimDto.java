package com.mjc813.swimpool.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwimDto {
    private Long id;
    private String name;
    private Integer lanes;
    private String laneType;
    private String phoneNumber;
    private String addr;
}

//- 기존의 MPA 처럼 DB, user, table 설계하고 생성해야 한다.
//- swimpool_db, swimmer,
//	swimpool_tbl (id, name, ranes, rane_type(25,50), phone_number, addr)
//- 수영장 정보를 CRUD 를 SPA 방식으로 할수 있는 웹 1개 화면이 있는 프로젝트
//- SPA 웹 화면의 C/R 1개/U 는 modal popup 창으로 처리한다.
