package com.mjc813.swimpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swim")
public class SwimController {
    @GetMapping("")
    public String getView(){
        return "swim/swim";
    }
}
