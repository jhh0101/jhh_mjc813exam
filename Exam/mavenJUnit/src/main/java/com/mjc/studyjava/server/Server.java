package com.mjc.studyjava.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Integer port;

    public Server(Integer port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        Session session = new Session(socket);
        Thread thread = new Thread(session);
        thread.start();
    }
}
