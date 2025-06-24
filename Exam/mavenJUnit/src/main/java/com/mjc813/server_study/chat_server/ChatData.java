package com.mjc813.server_study.chat_server;

public class ChatData {
    /**
     * 명령어
     */
    private ChatCommand command;
    /**
     * 대화방 고유번호
     */
    private Integer room;
    /**
     * 보낼 데이터 (명령어의 정보, 채팅메세지)
     */
    private String data;
}
