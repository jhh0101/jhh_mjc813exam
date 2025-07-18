package com.mjc813.webcrud.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository mR;

    @GetMapping("")
    public String member(){
        return "member/index";
    }

    @GetMapping("/add")
    public String memberAdd(){
        return "member/add";
    }

    @PostMapping("/insert")
    public String addMember(@ModelAttribute MemberDto m){
        mR.addMember(m);
        return "redirect:/member";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<MemberDto> list = mR.list();
        model.addAttribute("list", list);
        return "member/list";
    }

    @GetMapping("/view/{id}")
    public String one(@PathVariable("id") Long id, Model model, MemberDto m){
        MemberDto one = mR.one(m);
        model.addAttribute("one", one);
        return "member/view";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, MemberDto m, Model model){
        MemberDto one = mR.one(m);
        model.addAttribute("one", one);
        return "member/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto m){
        mR.modify(m);
        return "redirect:/member/list";
    }

}
