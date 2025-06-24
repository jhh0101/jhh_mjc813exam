package com.mjc813.server_study.chat_server.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * ChatServerApp 는 접속하는 클라이언트들을 컬렉션 형태로 저장해야 한다.
 * 이 객체 1개는 클라이어트 1개 접속한 정보를 가지고 있다.
 */
@Getter
@Setter
@AllArgsConstructor
public class ChatClientInfo extends Thread {
    /**
     * 서버가 클라이언트와 통신할 클라이언트소켓
     */
    private Socket socket;
    /**
     * 서버가 클라이언트로부터 데이터를 읽을때 사용할 버퍼스트림리더
     */
    private BufferedReader br;
    /**
     * 서버가 클라이언트에게 데이터를 보낼때 사용할 버퍼스트림Writer
     */
    private BufferedWriter bw;

    /**
     * 클라이언트의 대화명
     */
    private String userName;
    /**
     * 클라이언트가 입장한 대화방 id, 0이거나 null 이면 대화방 퇴장
     */
    private Integer chattingRoomId;

    @Override
    public void run() {
        try {
            while(true) {
                String str = this.br.readLine();
            }
        } catch (IOException e) {
            System.out.println("socket 종료");
        }
    }

    public void close() {
        try {
            this.bw.close();
            this.br.close();
            this.socket.close();
        } catch (IOException e) {
        }
    }

    public void write(String str) throws IOException {
        this.bw.write(str);
        this.bw.newLine();
        this.bw.flush();
    }
}
