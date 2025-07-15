package com.example.demo.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MyController {
    @GetMapping("/my")
    public String my(Model model){
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("time", now);
        return "my";
    }
}
