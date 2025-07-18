package com.mjc813.webcrud.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRepository {
    private final IMemberMapper iM;

    public MemberRepository(IMemberMapper iM) {
        this.iM = iM;
    }

    public void addMember(MemberDto m){
        iM.addMember(m);
    }
}
