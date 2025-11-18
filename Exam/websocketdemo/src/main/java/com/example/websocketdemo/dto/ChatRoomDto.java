package com.example.websocketdemo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomDto {
	private String roomName;								// 채팅방 이름
	private Long roomId;									// 채팅방 id

	@Builder.Default
	private List<ChatWebSocketSession> chatUserList = new ArrayList<>();		// 채팅방에 연결된 사용자들

	public Integer getCount() {
		return chatUserList == null ? 0 : chatUserList.size();
	}
}
