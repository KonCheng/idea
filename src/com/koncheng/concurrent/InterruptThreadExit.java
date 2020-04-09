package com.koncheng.concurrent;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println("running");
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
