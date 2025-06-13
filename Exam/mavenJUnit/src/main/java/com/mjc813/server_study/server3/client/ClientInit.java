package com.mjc813.server_study.server3.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientInit {
    public void init(String ipAddr, int port, Socket sck) throws IOException {
        SocketAddress sa = new InetSocketAddress(ipAddr, port);
        sck.connect(sa);

        // Ip 주소와 포트로 접속한다.
    }
}
