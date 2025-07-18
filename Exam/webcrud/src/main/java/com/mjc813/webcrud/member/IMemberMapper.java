package com.mjc813.webcrud.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMemberMapper {
    void addMember(MemberDto m);
    List<MemberDto> list();
    MemberDto one(MemberDto m);
}
