package com.mjc.studyjava.client;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client("10.11.83.70", 54321);
        client.start();

    }
}
