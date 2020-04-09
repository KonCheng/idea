package com.koncheng.concurrent;

import java.util.concurrent.TimeUnit;

public class HookThread {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("JVM is shutting down");
        }));

        System.out.println("main method is closing");
    }
}
