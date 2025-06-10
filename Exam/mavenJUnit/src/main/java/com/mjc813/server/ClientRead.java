package com.mjc813.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientRead implements Runnable{
    private final BufferedReader reader;

    public ClientRead(InputStreamReader iR) {
        this.reader = new BufferedReader(iR);
    }
    @Override
    public void run() {
        try {
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    System.out.println("서버 연결 종료됨");
                    break;
                }
                if ("exit".equals(str)) {
                    str = "exit!@#$app";
                    System.out.println("상대 : " + str);
                    System.out.println("서버 연결 종료됨");
                    break;
                }
                System.out.println("상대 : " + str);
            }
        } catch (IOException e) {
            System.out.println("서버 연결 종료됨");
        }finally {
            try {
                reader.close();
                System.exit(0);
            } catch (IOException e) {
            }
        }
    }
}
