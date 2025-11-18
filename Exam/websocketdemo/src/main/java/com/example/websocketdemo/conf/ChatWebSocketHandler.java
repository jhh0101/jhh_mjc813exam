package com.example.websocketdemo.conf;

import com.example.websocketdemo.dto.ChatMessageDto;
import com.example.websocketdemo.dto.ChatMessageType;
import com.example.websocketdemo.dto.ChatRoomDto;
import com.example.websocketdemo.dto.ChatWebSocketSession;
import com.example.websocketdemo.service.ChatRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

@Slf4j
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
	@Autowired
	private ChatRoomService chatRoomService;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		try {
			String payload = message.getPayload();
			ChatMessageDto chatMessageDto = this.objectMapper.readValue(payload, ChatMessageDto.class);
			ChatRoomDto findRoom = this.chatRoomService.findByRoomId(chatMessageDto.getRoomId());
			if ( findRoom == null ) {
				return;
			}
			if ( chatMessageDto.getMsgType() == ChatMessageType.ENTER ) {
				this.enterRoom(session, findRoom, chatMessageDto);
			} else if ( chatMessageDto.getMsgType() == ChatMessageType.OUT ) {
				this.quitRoom(session, findRoom, chatMessageDto);
			} else if ( chatMessageDto.getMsgType() == ChatMessageType.MESSAGE ){
				this.sendMessageRoom(findRoom, chatMessageDto);
			}
		} catch (Exception ex) {
			log.error(ex.toString());
		}
	}

	private void enterRoom(WebSocketSession session, ChatRoomDto chatRoomDto, ChatMessageDto chatMessageDto ) throws JsonProcessingException {
		ChatWebSocketSession chatWebSocketSession = ChatWebSocketSession.builder()
				.webSocketSession(session)
				.writer(chatMessageDto.getWriter())
				.build();
		chatRoomDto.getChatUserList().add(chatWebSocketSession);
		String msg = String.format("%s 님이 입장했습니다.", chatMessageDto.getWriter());
		chatMessageDto.setMessage(msg);
		this.sendMessageRoom(chatRoomDto, chatMessageDto);
	}

	private void quitRoom(WebSocketSession session, ChatRoomDto chatRoomDto, ChatMessageDto chatMessageDto ) throws JsonProcessingException {
		ChatWebSocketSession findchatWebsocketSession = this.findChatWebSocketSession(session, chatRoomDto);
		if ( findchatWebsocketSession == null ) {
			return;
		}
		chatRoomDto.getChatUserList().remove(findchatWebsocketSession);
		String msg = String.format("%s 님이 퇴장했습니다.", chatMessageDto.getWriter());
		chatMessageDto.setMessage(msg);
		this.sendMessageRoom(chatRoomDto, chatMessageDto);
		if ( chatRoomDto.getCount() <= 0) {
			// 대화자 수가 0명이면 대화방을 삭제한다.
			this.chatRoomService.deleteByRoomId(chatRoomDto.getRoomId());
		}
	}

	private ChatWebSocketSession findChatWebSocketSession(WebSocketSession session, ChatRoomDto chatRoomDto ) {
		for (ChatWebSocketSession webSocketSession : chatRoomDto.getChatUserList() ) {
			if ( session.getId().equals(webSocketSession.getWebSocketSession().getId()) ) {
				return webSocketSession;
			}
		}
		return null;
	}

	private void sendMessageRoom(ChatRoomDto chatRoomDto, ChatMessageDto chatMessageDto ) throws JsonProcessingException {
		String message = this.objectMapper.writeValueAsString(chatMessageDto);
		TextMessage tm = new TextMessage(message);
		for (ChatWebSocketSession webSocketSession : chatRoomDto.getChatUserList() ) {
			try {
				webSocketSession.getWebSocketSession().sendMessage(tm);
			} catch (Exception ex) {
				log.error(ex.toString());
			}
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error(exception.toString());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		List<ChatRoomDto> all = this.chatRoomService.findAll();
		for ( ChatRoomDto chatRoomDto : all ) {
			try {
				ChatWebSocketSession findWebSession = this.findChatWebSocketSession(session, chatRoomDto);
				if ( findWebSession == null ) {
					continue;
				}
				ChatMessageDto chatMessageDto = ChatMessageDto.builder()
						.writer(findWebSession.getWriter())
						.build();
				this.quitRoom(session, chatRoomDto, chatMessageDto);
			} catch (Exception ex) {
				log.error(ex.toString());
			}
		}
	}
}
