package com.example.websocketdemo.service;

import com.example.websocketdemo.dto.ChatRoomDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatRoomService {
	private final Map<Long, ChatRoomDto> chatRoomCollection = new HashMap<>();

	public ChatRoomDto insert(String roomName) {
		ChatRoomDto newRoom = ChatRoomDto.builder()
				.roomName(roomName)
				.roomId(this.getNewId()).build();
		this.chatRoomCollection.put(newRoom.getRoomId(), newRoom);
		return newRoom;
	}

	private Long getNewId() {
		Long newId = this.chatRoomCollection.values().stream()
				.mapToLong(x -> x.getRoomId()).max().orElse(0L);
		return newId + 1;
	}

	public ChatRoomDto findByRoomId(Long roomId) {
		ChatRoomDto findRoom = this.chatRoomCollection.values().stream()
				.filter(x -> roomId == x.getRoomId()).findAny().orElse(null);
		return findRoom;
	}

	public List<ChatRoomDto> findAll() {
		return this.chatRoomCollection.values().stream().toList();
	}

	public void deleteByRoomId(Long roomId) {
		this.chatRoomCollection.remove(roomId);
	}
}
