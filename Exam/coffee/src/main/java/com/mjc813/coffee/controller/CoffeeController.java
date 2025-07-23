package com.mjc813.coffee.controller;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/add")
    public String addView(){
        return "coffee/add";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.insert(coffeeDto);
        return "redirect:/coffee/list";
    }

    @GetMapping("/list")
    public String selectAll(Model model){
        List<CoffeeDto> list = coffeeService.selectAll();
        model.addAttribute("list", list);
        return "coffee/list";
    }

    @GetMapping("/one")
    public String selectById(@RequestParam("id") Long id
                            , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("item", coffeeDto);
        return "coffee/one";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id
                        , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("item", coffeeDto);
        return "coffee/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.update(coffeeDto);
        return "redirect:/coffee/one?id="+coffeeDto.getId();
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.delete(coffeeDto.getId());
        return "redirect:/coffee/list";
    }
}
