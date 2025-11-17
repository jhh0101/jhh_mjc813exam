package com.example.weboketdemo.controller;


import com.example.weboketdemo.dto.ChatRoomDto;
import com.example.weboketdemo.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/list")
    public String getRoomList(Model model) {
        List<ChatRoomDto> all = this.chatRoomService.findAll();
        model.addAttribute("list", all);
        return "/chat/roomlist";
    }

    @PostMapping("/insert")
    public String insertRoom(Model model, String roomName) {
        this.chatRoomService.insert(roomName);
        return "redirect:/chat/list";
    }

    @GetMapping("/enter")
    public String enterRoom(Model model, Long roomId, String writer) {
        ChatRoomDto find = this.chatRoomService.findByRoomId(roomId);
        if (find == null) {
            return  "redirect:/chat/list";
        }
        model.addAttribute("room", find);
        model.addAttribute("writer", writer);
        return   "/chat/room";

    }



}
