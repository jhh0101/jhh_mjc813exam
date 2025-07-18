package com.mjc813.webcrud.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository mR;

    @GetMapping("/")
    public String member(){
        return "member/index";
    }

    @GetMapping("/add")
    public String memberAdd(){
        return "member/add";
    }

    @PostMapping("/insert")
    public String memberInsert(@ModelAttribute MemberDto m){
        mR.addMember(m);
        return "redirect:/member";
    }
}
