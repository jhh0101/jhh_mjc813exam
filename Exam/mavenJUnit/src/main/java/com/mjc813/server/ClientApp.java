package com.mjc813.server;

import java.io.*;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        Socket sck = new Socket();
        ClientInit cI = new ClientInit();

        System.out.println("Client start");

        try {
            cI.init("10.11.83.70", 19999, sck); //10.11.83.70
            ClientWrite cw = new ClientWrite(new OutputStreamWriter(sck.getOutputStream()));
            ClientRead cr = new ClientRead(new InputStreamReader(sck.getInputStream()));

            Thread read = new Thread(cr, "clientRead");
            Thread write = new Thread(cw, "clientWrite");

            read.start();
            write.start();

            read.join();
            write.join();

        } catch (IOException | InterruptedException e) {
            System.err.println(e.toString());
        }
    }
}