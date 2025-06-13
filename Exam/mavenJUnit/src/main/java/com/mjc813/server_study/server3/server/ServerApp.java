package com.mjc813.server_study.server3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    private static Socket socket;

    public static void main(String[] args) {
        System.out.println("서버 시작");
        try (ServerSocket serverSocket = new ServerSocket()) {
            System.out.println("클라이언트 연결 대기중 ...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("새 클라이언트 접속 : " + clientSocket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            System.out.println("서버를 시작할 수 없습니다.");
        }

    }
}
