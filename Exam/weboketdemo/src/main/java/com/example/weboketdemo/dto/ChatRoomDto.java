package com.example.weboketdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomDto {
    private String roomName;                                // 채팅방 이름
    private Long id;                                        // 채팅방 id

    @Builder.Default
    private List<ChatWebSocketSession> chatUserList = new ArrayList<>();        // 채팅방에 연결된 사용자들

    public Integer getCount() {
        return chatUserList == null ? 0 : chatUserList.size();
    }
}
