package com.mjc813.webcrud.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRepository {
    private final IMemberMapper iM;

    public MemberRepository(IMemberMapper iM) {
        this.iM = iM;
    }

    public void addMember(MemberDto m){
        iM.addMember(m);
    }

    public List<MemberDto> list(){
        return iM.list();
    }

    public MemberDto one(MemberDto m){
        return iM.one(m);
    }
}
