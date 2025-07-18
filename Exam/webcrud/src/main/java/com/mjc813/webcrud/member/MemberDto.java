package com.mjc813.webcrud.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String nickName;
}
