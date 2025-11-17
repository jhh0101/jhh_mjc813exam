package com.example.weboketdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    private ChatMessageType msgType;                        // 메세지 형태
    private Long roomId;                                    // 채팅방 유일한 번호
    private String writer;                                    // 대화명
    private String message;
}
