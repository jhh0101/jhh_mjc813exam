package com.mjc813.server;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ClientWrite implements Runnable {
    private final BufferedWriter bw;
    Scanner sc = new Scanner(System.in);

    public ClientWrite(OutputStreamWriter os) {
        this.bw = new BufferedWriter(os);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = sc.nextLine();
                if ("exit".equals(message) || message == null) {
                    message = "exit!@#$app";
                    try {
                        bw.write(message);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e) {
                        try {
                            bw.close();
                        } catch (IOException ex) {
                        }
                    }
                    break;
                }
                try {
                    System.out.println("나 : " + message);
                    bw.write(message);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                    }
                }

            }
        } catch (RuntimeException e) {
        }finally {
            try {
                bw.close();
                System.exit(0);
            } catch (IOException e) {
            }
        }

    }
}
