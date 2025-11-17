package com.example.weboketdemo.service;

import com.example.weboketdemo.dto.ChatRoomDto;
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
                .id(this.getNewId())
                .build();
        this.chatRoomCollection.put(newRoom.getId(), newRoom);
        return newRoom;
    }

    private Long getNewId() {
        Long newId = this.chatRoomCollection.values().stream()
                .mapToLong(ChatRoomDto::getId).max().orElse(0L);
        return newId + 1;
    }

    public ChatRoomDto findByRoomId(Long id) {
        return this.chatRoomCollection.values().stream()
                .filter(room -> room.getId().equals(id)).findAny().orElse(null);
    }

    public List<ChatRoomDto> findAll() {
        return this.chatRoomCollection.values().stream().toList();
    }

    public void deleteByRoomId(Long id) {
        this.chatRoomCollection.remove(id);
    }
}
