package com.mjc813.coffee.controller;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.PageInfoDto;
import com.mjc813.coffee.dto.PagingDto;
import com.mjc813.coffee.service.CoffeeService;
import com.mjc813.coffee.util.PageUtils;
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
    public String addView(Model model
            , @RequestParam(value = "page", defaultValue = "1") Integer page
            , @RequestParam(value = "rows", defaultValue = "5") Integer rows){
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        return "coffee/add";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto
    , @ModelAttribute PagingDto pagingDto){
        coffeeService.insert(coffeeDto);
        return "redirect:/coffee/list?page="+pagingDto.getPage()+"&rows="+pagingDto.getRows();
    }

    @GetMapping("/list")
    public String selectAll(Model model
    , @RequestParam(value = "page", defaultValue = "1") Integer page
    , @RequestParam(value = "rows", defaultValue = "5") Integer rows
    , @RequestParam(value = "keyWord", defaultValue = "") String keyWord){

        PagingDto pagingDto = new PagingDto(rows, page, 0, keyWord);
        int totalCount = coffeeService.count(pagingDto);

        PageInfoDto pageInfo = PageUtils.getPageInfo(pagingDto, totalCount);
        List<CoffeeDto> list = coffeeService.selectAll(pagingDto);

        model.addAttribute("prev", pageInfo.getPrev());
        model.addAttribute("next", pageInfo.getNext());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pagingDto", pagingDto);
        model.addAttribute("list", list);

        return "coffee/list";
    }

    @GetMapping("/one")
    public String selectById(@RequestParam("id") Long id
    , @RequestParam(value = "page", defaultValue = "1") Integer page
    , @RequestParam(value = "rows", defaultValue = "5") Integer rows
    , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        model.addAttribute("item", coffeeDto);
        return "coffee/one";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id
    , @RequestParam(value = "page", defaultValue = "1") Integer page
    , @RequestParam(value = "rows", defaultValue = "5") Integer rows
    , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        model.addAttribute("item", coffeeDto);
        return "coffee/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto
    , @ModelAttribute PagingDto pagingDto){
        coffeeService.update(coffeeDto);
        return "redirect:/coffee/one?id="+coffeeDto.getId()+"&page="+pagingDto.getPage()+"&rows="+pagingDto.getRows();
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute CoffeeDto coffeeDto
    , @ModelAttribute PagingDto pagingDto){
        coffeeService.delete(coffeeDto.getId());
        return "redirect:/coffee/list?page="+pagingDto.getPage()+"&rows="+pagingDto.getRows();
    }
}
