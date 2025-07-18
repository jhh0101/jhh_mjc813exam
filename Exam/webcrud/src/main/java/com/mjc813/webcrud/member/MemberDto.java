package com.mjc813.webcrud.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String nickName;
}
