package com.example.weboketdemo.service;

import com.example.weboketdemo.dto.ChatRoomDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestChatRoomService {

    @Autowired
    private ChatRoomService chatRoomService;

    @Test
    public void testChatRoomCRD(){
        this.chatRoomService.insert("abc");
        assertThat(this.chatRoomService.findAll().size()).isEqualTo(1);
        this.chatRoomService.insert("def");
        assertThat(this.chatRoomService.findAll().size()).isEqualTo(2);
        this.chatRoomService.insert("ghi");
        assertThat(this.chatRoomService.findAll().size()).isEqualTo(3);

        ChatRoomDto find = this.chatRoomService.findByRoomId(3L);
        assertThat(find).isNotNull();
        assertThat(find.getId()).isEqualTo(3L);

        this.chatRoomService.deleteByRoomId(1L);
        assertThat(this.chatRoomService.findAll().size()).isEqualTo(2);
    }
}
