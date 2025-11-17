package com.example.weboketdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatWebSocketSession {

    private WebSocketSession webSocketSession;
    private String writer;
}
