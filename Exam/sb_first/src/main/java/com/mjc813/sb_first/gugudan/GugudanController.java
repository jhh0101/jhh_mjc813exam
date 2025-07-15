package com.mjc813.sb_first.gugudan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GugudanController {

    @GetMapping("/gugudan")
    public String gugudan(@RequestParam("num") Integer num, Model model){
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(num + " X " + i + " = " + num*i);
        }
        model.addAttribute("list", list);
        return "gugudan";
    }
}
