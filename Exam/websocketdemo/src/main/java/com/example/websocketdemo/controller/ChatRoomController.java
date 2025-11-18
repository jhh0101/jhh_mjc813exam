package com.example.websocketdemo.controller;

import com.example.websocketdemo.dto.ChatRoomDto;
import com.example.websocketdemo.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/websocket")
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
	public String insertRoom(Model model, String roomName, String writer) {
		ChatRoomDto insertRoom = this.chatRoomService.insert(roomName);
//		return "redirect:/websocket/list";
		return String.format("redirect:/websocket/enter?roomId=%s&writer=%s", insertRoom.getRoomId()
				, URLEncoder.encode(writer, StandardCharsets.UTF_8));
	}

	@GetMapping("/enter")
	public String enterRoom(Model model, Long roomId, String writer) {
		ChatRoomDto find = this.chatRoomService.findByRoomId(roomId);
		if ( find == null ) {
			return "redirect:/websocket/list";
		}
		model.addAttribute("chatRoom", find);
		model.addAttribute("writer", writer);
		return "/chat/room";
	}
}
