package com.mjc813.mpacrud.animal.controller;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.mybatis.AnimalMybatisMapper;
import com.mjc813.mpacrud.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/a")
    public String testA(Model model, @RequestParam("name1") String name1,@RequestParam("name2") String name2,@RequestParam("name3") String name3){
        model.addAttribute("name1", name1);
        model.addAttribute("name2", name2);
        model.addAttribute("name3", name3);
        return "a";
    }

    @GetMapping("/addview")
    public String addView(){
        return "/animal/addview";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute AnimalDto animalDto){
        animalService.insert(animalDto);
        return "redirect:/";
    }
}
