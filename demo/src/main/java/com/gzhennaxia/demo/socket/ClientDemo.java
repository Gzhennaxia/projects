package com.gzhennaxia.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author bo li
 * @date 2020-10-16 14:35
 */
public class ClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hi, i am client.".getBytes());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            if (len > 0) {
                System.out.println("服务端响应：" + new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
