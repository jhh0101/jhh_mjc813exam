package com.mjc813.sb_first.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/page")
    public String page(){
        return "page";
    }
}
