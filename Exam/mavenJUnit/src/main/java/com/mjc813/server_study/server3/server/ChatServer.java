//package com.mjc813.server_study.server3.server;
//
//import com.mjc813.server_study.server3.client.SocketClient;
//import netscape.javascript.JSObject;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ChatServer {
//    ServerSocket serverSocket;
//    ExecutorService threadPool = Executors.newFixedThreadPool(100);
//    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
//
//    public void start() throws IOException {
//        serverSocket = new ServerSocket(50001);
//        System.out.println("[서버] 시작 됨");
//
//        Thread thread = new Thread(() -> {
//            try {
//                while(true){
//                    Socket socket = serverSocket.accept();
//                }
//            } catch (IOException e) {
//            }
//        });
//        thread.start();
//    }
//    public void addSocketClient(SocketClient socketClient){
//        String key = socketClient.chatName + "@" + socketClient.clientIp;
//        chatRoom.remove(key);
//        System.out.println("나감 : " + key);
//        System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
//    }
//    public void sendToAll(SocketClient sender, String message){
//        JSONObject root = new JSONObject();
//        root.put("ClientIp", sender.clientIp);
//        root.put("chatName",sender.chatName);
//        root.put("message", message);
//        String json = root.toString();
//
//        Collection<SocketClient> socketClients = chatRoom.values();
//        for (SocketClient sc : socketClients) {
//            if(sc == send){
//                continue;
//            }
//            sc.send(json);
//        }
//    }
//    public void stop(){
//        try {
//            serverSocket.close();
//            threadPool.shutdownNow();
//            chatRoom.values().stream().forEach(sc -> sc.close());
//        } catch (IOException e) {
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            ChatServer chatServer = new ChatServer();
//            chatServer.start();
//
//            System.out.println("----------------------------------------------------");
//            System.out.println("서버를 종료하려면 q를 입력하고 Enter");
//            System.out.println("----------------------------------------------------");
//
//            Scanner scanner = new Scanner(System.in);
//        } catch (IOException e) {
//        }
//    }
//}