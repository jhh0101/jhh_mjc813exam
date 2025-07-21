package com.mjc813.mpacrud.animal.controller;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.mybatis.AnimalMybatisMapper;
import com.mjc813.mpacrud.animal.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
        return "animal/addview";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute AnimalDto animalDto){
        try{
            animalService.insert(animalDto);
        } catch (Throwable e){
            System.err.println(e.toString());
        }
        return "redirect:/animal/findAll";
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        try{
            List<AnimalDto> list = animalService.findAll();
            model.addAttribute("list", list);
        }catch (Throwable e){
            System.err.println(e.toString());
        }
        return "animal/list";
    }

    @GetMapping("/view")
    public String findView(@RequestParam("id") Long id, Model model){
        AnimalDto animalDto = animalService.findById(id);
        model.addAttribute("data", animalDto);
        return "animal/view";
    }

    @GetMapping("/modify")
    public String modify(Model model,@RequestParam("id") Long id){
        AnimalDto animalDto = animalService.findById(id);
        model.addAttribute("data", animalDto);
        return "animal/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute AnimalDto animalDto){
        animalService.modify(animalDto);
        return "redirect:/animal/view?id="+animalDto.getId();
    }

    @PostMapping("/delete")
    public String delete(AnimalDto animalDto){
        animalService.delete(animalDto.getId());
        return "redirect:/animal/findAll";
    }
}
