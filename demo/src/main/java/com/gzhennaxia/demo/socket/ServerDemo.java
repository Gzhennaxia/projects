package com.gzhennaxia.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bo li
 * @date 2020-10-16 14:28
 */
public class ServerDemo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("连接成功，客户端：" + socket.getRemoteSocketAddress());
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if (len > 0) {
                    System.out.println("客户端数据：" + new String(buffer, 0, len));
                }
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Hi, I am server.".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
