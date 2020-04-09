package com.koncheng.nio;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

public class ConnectUrl {
    public static void main(String[] args) {
        String urlName = "http://127.0.0.1:8080/web/cookie";
        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

            connection.connect();

            connection.getHeaderFields().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

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
