package com.mjc813.server_study.chat_server.server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ChatServerApp extends Thread implements IClientProccess {
    private ServerSocket serverSocket;  // 클라이언트 접속 대기
    private List<ChatClientInfo> clientInfoList = new LinkedList<>();
    private List<ChatRoomInfo> roomInfoList = new LinkedList<>();

    public void init(int port) throws IOException {
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(new InetSocketAddress(port));
    }

    public void accept() throws IOException {
        Socket socket = this.serverSocket.accept();
        System.out.printf("accept Client : %s\n", socket);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );
        ChatClientInfo csb = new ChatClientInfo(socket, br, bw, "", 0);
        csb.start();
        synchronized (this.clientInfoList) {
            this.clientInfoList.add(csb);
        }
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public void write(String str) throws IOException {
//        if(exitWord.equals(str)) {
//            str = exitCommand;
//        }
//        this.sendAllTargets(str);
    }

    public int sendRoomTarget(Integer roomId, String str) {
//        for ( ClientSocketBuffer csb : clients) {
//            try {
//                csb.write(str);
//            } catch (IOException ex) {
//                System.out.printf("해당 클라이언트[%s] 접속 끊겼음", csb.getSocket().getRemoteSocketAddress());
//            }
//        }
        return 0;
    }

    @Override
    public void deleteClient(Integer roomId, ChatClientInfo clientInfo) {
//        synchronized (this.clients) {
//            this.clients.remove(deletObject);
//        }
    }

    public static void main(String[] args) {
        System.out.println("Chat Server App start");

        ChatServerApp sjp = new ChatServerApp();
        try {
//            sjp.init(59999);
//            sjp.start();
//
//            Scanner scan = new Scanner(System.in);
//            while( true ) {
//                String str = scan.nextLine();   // 키보드 입력 대기, 블로킹상태
//                sjp.write(str);
//                if( exitWord.equals(str) ) {
//                    break;
//                }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                this.accept();
            }
        } catch (Exception ex) {
            System.out.println("서버 종료");
        } finally {
            try {
                this.close();
            } catch (IOException e) {
            }
        }
    }
}
