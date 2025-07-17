package com.mjc813.contact_web.controller;

import com.mjc813.contact_web.dto.ContactDto;
import com.mjc813.contact_web.service.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/add")
    public String addView(){
        return "contact/add";
    }

    @PostMapping("/addconfirm")
    public String addConfirm(@ModelAttribute ContactDto contact){
        System.out.println(contact.getContactFullInfo());
        contactRepository.insert(contact);
        return "redirect:/contact/listAll";
    }

    @GetMapping("/listAll")
    public String listView(Model model,@ModelAttribute ContactDto contact){
        try {
            List<ContactDto> contactDto = contactRepository.selectAll(contact);
            model.addAttribute("list", contactDto);
        }catch (Throwable e){
            System.out.println(e.toString());
        }
        return "contact/list";
    }

    @GetMapping("/select")
    public String selectView(Model model, @RequestParam("id") Integer id){
        try {
            ContactDto con = contactRepository.select(id);
            model.addAttribute("select",con);
        }catch (Throwable e){
            System.out.println(e.toString());
        }
        return "contact/select";
    }

    @GetMapping("/modify")
    public String modifyView(Model model, @RequestParam("id") Integer id){
        ContactDto con = contactRepository.select(id);
        model.addAttribute("modify", con);
        return "contact/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ContactDto contact){
        contactRepository.update(contact);
        return "redirect:/contact/listAll";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute ContactDto contact){
        contactRepository.delete(contact.getId());
        return "redirect:/contact/listAll";
    }
}
