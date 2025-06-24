package com.mjc813.server_study.chat_server.client;

import com.mjc813.server_study.chat_server.ChatCommand;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp  implements Runnable {
    private ClientCommand clientCommand;
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    public void connect( String ip, int port ) throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(ip, port));
        this.bw = new BufferedWriter(
                new OutputStreamWriter(this.socket.getOutputStream())
        );
        this.br = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
        );
    }

    public void write(String str) throws IOException {
        this.bw.write(str);
        this.bw.newLine();
        this.bw.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.read();
            }
        } catch (Exception ex) {
            System.out.println("exit run Thread");
        }
    }

    public void read() throws IOException {
        String s = this.br.readLine();  // 통신소켓에서 데이터를 입력받기 대기 (블로킹 상태 발생)
    }

    public void close() throws IOException {
        this.br.close();
        this.bw.close();
        this.socket.close();
    }

    public static void main(String[] args) {
        System.out.println("Chat Client App start");
        ChatClientApp cca = new ChatClientApp();
        Scanner scan = new Scanner(System.in);
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    private void ParseInput(String str){
        if(this.clientCommand.getClientMode() == ClientMode.MENU){
            switch (str){
                case "1" -> {
                    this.clientCommand.setFirstMenu(ChatCommand.CHNAME);
                    this.clientCommand.setClientMode(ClientMode.SUBMENU);
                }
                case "2" -> {
                    this.clientCommand.setFirstMenu(ChatCommand.ROOMLIST);
                }
                case "3" -> {
                    this.clientCommand.setFirstMenu(ChatCommand.CREATEROOM);
                }
                case "4" -> {
                    this.clientCommand.setFirstMenu(ChatCommand.ENTERROOM);
                }
                case "q" -> {
                    this.clientCommand.setFirstMenu(ChatCommand.EXIT);
                }
            }
        }else if(this.clientCommand.getClientMode() == ClientMode.CHATTING) {

        }
    }
}
