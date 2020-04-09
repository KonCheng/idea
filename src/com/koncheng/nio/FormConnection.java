package com.koncheng.nio;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class FormConnection {
    public static void main(String[] args) {
        String urlName = "http://127.0.0.1:8080/web/post";
        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setDoOutput(true);

            connection.connect();

            JSONObject data = new JSONObject();
            data.put("key", "value");
            data.put("key2", "value2");

            try (PrintWriter writer = new PrintWriter(connection.getOutputStream(), true)) {
                writer.println(data.toString());
            }


            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }

            try (InputStream inputStream = connection.getInputStream()) {
                try (Scanner scanner = new Scanner(inputStream, encoding)) {
                    while (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        System.out.println(message);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
