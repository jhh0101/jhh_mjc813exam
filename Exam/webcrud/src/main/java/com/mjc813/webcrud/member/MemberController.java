package com.mjc813.webcrud.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/")
    public String member(){
        return "member/index";
    }

    @GetMapping("/add")
    public String memberAdd(){
        return "member/add";
    }
}
