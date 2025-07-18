package com.mjc813.webcrud.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberMapper {
    void addMember(MemberDto m);
}
