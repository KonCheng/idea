package com.koncheng.nio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000)) {
            new Thread(new ReadMessage(socket.getInputStream())).start();

            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    socket.shutdownInput();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                try {
                    writer.println(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class ReadMessage implements Runnable {

        private InputStream inputStream;

        public ReadMessage(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                System.out.println("Received a message:\n" + message);
            }
        }
    }
}
