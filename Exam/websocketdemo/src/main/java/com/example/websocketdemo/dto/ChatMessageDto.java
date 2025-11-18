package com.example.websocketdemo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
	private ChatMessageType msgType;						// 메세지 형태
	private Long roomId;									// 채팅방 유일한 번호
	private String writer;									// 대화명
	private String message;									// 메세지
}
