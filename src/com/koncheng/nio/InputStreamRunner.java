package com.koncheng.nio;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreamRunner {
    public static void main(String[] args) {
        Path path = Paths.get("E://", "com/text.txt");
        File file = path.toFile();
        if (!file.exists()) {
            System.out.println("File not exist");
        }
        try {
            InputStream inputStream = new FileInputStream(file);
            int read;
            while ((read = inputStream.read()) > 0) {
                System.out.println((char) read);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {

        }
    }
}
