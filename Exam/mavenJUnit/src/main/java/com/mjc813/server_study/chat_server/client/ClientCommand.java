package com.mjc813.server_study.chat_server.client;

import com.mjc813.server_study.chat_server.ChatCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCommand {
    private ClientMode clientMode = ClientMode.MENU;
    private ChatCommand firstMenu;
    private String secondData;
}
