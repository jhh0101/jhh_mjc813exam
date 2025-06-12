package com.mjc813.server_study.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) {
        System.out.println("다중 접속 채팅 서버 시작...");
        int portNumber = 19999;

        ClientHandlerManager manager = new ClientHandlerManager();

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("서버가 " + portNumber + " 포트에서 클라이언트 연결을 기다립니다...");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("새 클라이언트 접속: " + clientSocket.getRemoteSocketAddress());

                    ClientHandler clientHandler = new ClientHandler(clientSocket, manager, serverSocket);
                    Thread thread = new Thread(clientHandler);
                    thread.start();

                } catch (IOException e) {

                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.err.println("서버 소켓을 열 수 없습니다: " + e.getMessage());
        }
    }

}