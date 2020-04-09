package com.koncheng.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketChannelRunner {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8000) {
        };
        try {
            SocketChannel socketChannel = SocketChannel.open(socketAddress);
            Scanner scanner = new Scanner(socketChannel, StandardCharsets.UTF_8);
            OutputStream outputStream = Channels.newOutputStream(socketChannel);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
            new Thread(new ReadMessage(scanner)).start();

            Scanner sysInScanner = new Scanner(System.in);
            while (sysInScanner.hasNextLine()) {
                String message = sysInScanner.nextLine();
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ReadMessage implements Runnable {

        private Scanner scanner;

        public ReadMessage(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public void run() {
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                System.out.println("Received a message:");
                System.out.println(message);
            }
        }
    }
}
