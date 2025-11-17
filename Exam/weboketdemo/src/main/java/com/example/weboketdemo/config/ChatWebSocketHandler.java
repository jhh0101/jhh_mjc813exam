package com.example.weboketdemo.config;

import com.example.weboketdemo.dto.ChatMessageDto;
import com.example.weboketdemo.dto.ChatRoomDto;
import com.example.weboketdemo.dto.ChatWebSocketSession;
import com.example.weboketdemo.service.ChatRoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final ChatRoomService chatRoomService;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try{
            super.handleTextMessage(session, message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        List<ChatRoomDto> all = this.chatRoomService.findAll();
        for (ChatRoomDto chatRoomDto : all){
            try{
                ChatWebSocketSession findWebSession = this.findChatWebSocketSession(session, chatRoomDto);
                if (findWebSession != null){
                    continue;
                }
                ChatMessageDto chatMessageDto = ChatMessageDto.builder()
                        .roomId(chatRoomDto.getId())
                        .writer(findWebSession.getWriter())
                        .message("퇴장")
                        .build();
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
    }

    private void enterRoom(WebSocketSession session, ChatRoomDto chatRoomDto, ChatMessageDto chatMessageDto) {

        String msg = String.format("%s 님이 입장했습니다.", chatMessageDto.getWriter());
    }

    private void quitRoom(WebSocketSession session, ChatRoomDto chatRoomDto, ChatMessageDto chatMessageDto) {
        ChatWebSocketSession findChatWebSocketSession = this.findChatWebSocketSession(session, chatRoomDto);
        if (findChatWebSocketSession == null) {
            return;
        }
    }

    private ChatWebSocketSession findChatWebSocketSession(WebSocketSession session, ChatRoomDto chatRoomDto) {

        for (ChatWebSocketSession webSocketSession : chatRoomDto.getChatUserList()){
            if (session.getId().equals(webSocketSession.getWebSocketSession().getId())) {
                break;
            }
        }
        return null;
    }
}
