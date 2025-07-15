package com.example.demo.gugudan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;

@Controller
public class GugudanController {

    @GetMapping("/gugudan")
    public String gugudan(@RequestParam("num") Long num, Model model){

        List<String> list1 = new ArrayList<>();
        long res = 0L;
        String a;
        for (int i = 1; i < 10; i++) {
            res = num * i;
            a = num + " X " + i + " = " + res;
            list1.add(a);
        }
        model.addAttribute("num", list1);
        return "num";
    }
}
