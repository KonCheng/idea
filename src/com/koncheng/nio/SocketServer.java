package com.koncheng.nio;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ConnectionHandler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ConnectionHandler implements Runnable {
        private Socket socket;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                    writer.println("Hi there, Enter \"bye\" to exit.");
                    boolean done = false;
                    while (!done && scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        System.out.println("Received a message:" + message);

                        writer.println(message);

                        if ("bye".equals(message.trim())) {
                            done = true;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
