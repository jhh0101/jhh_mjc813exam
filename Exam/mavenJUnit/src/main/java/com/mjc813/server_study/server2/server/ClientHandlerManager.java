package com.mjc813.server_study.server2.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ClientHandlerManager {

    private final List<PrintWriter> clientWriters = new Vector<>();
    private final List<Socket> clientSockets = new Vector<>();

    public void addClient(PrintWriter writer, Socket socket) {
        this.clientWriters.add(writer);
        this.clientSockets.add(socket);
    }

    public void removeClient(Socket socket) {
        this.clientSockets.remove(socket);
    }

    public void removeAllClient() throws IOException {
        for (Socket clientSocket : clientSockets) {
            clientSocket.close();
        }
        clientWriters.clear();
        clientSockets.clear();
    }

    public void sendMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }

}