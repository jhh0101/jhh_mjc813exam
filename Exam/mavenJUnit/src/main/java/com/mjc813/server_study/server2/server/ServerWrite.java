package com.mjc813.server_study.server2.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ServerWrite implements Runnable{
    private final PrintWriter writer;
    private final ClientHandlerManager manager;

    ServerWrite(PrintWriter writer, ClientHandlerManager manager){
        this.writer = writer;
        this.manager = manager;
    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        manager.sendMessage(message);
        writer.flush();
        if ("exitAll".equals(message)) {
            writer.close();
            try {
                manager.removeAllClient();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
