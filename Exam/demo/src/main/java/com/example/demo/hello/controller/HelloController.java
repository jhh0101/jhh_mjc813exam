package com.example.demo.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name, Model model){
        System.out.println("hello1 - "+name);
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name, Model model){
        System.out.println("hello2 - "+name);
        model.addAttribute("name", name);

        return "hello";
    }
}
