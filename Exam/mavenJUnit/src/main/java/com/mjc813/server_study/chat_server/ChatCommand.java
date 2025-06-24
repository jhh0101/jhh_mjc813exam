package com.mjc813.server_study.chat_server;

public enum ChatCommand {
    /**
     * 대화명 변경
     */
    CHNAME,
    /**
     * 대화방 목록
     */
    ROOMLIST,
    /**
     * 대화방 생성
     */
    CREATEROOM,
    /**
     * 대화방 입장
     */
    ENTERROOM,
    /**
     * 대화방 없음
     */
    EMPTYROOM,
    /**
     * 대화메세지
     */
    CHAT,
    EXIT;
}
