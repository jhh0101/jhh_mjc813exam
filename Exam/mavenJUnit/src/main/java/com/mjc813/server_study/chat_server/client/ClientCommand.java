package com.mjc813.server_study.chat_server.client;


import com.mjc813.server_study.chat_server.ChatData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCommand {
    private ClientMode clientMode = ClientMode.MENU;
    private ChatData chatData = new ChatData();
}
