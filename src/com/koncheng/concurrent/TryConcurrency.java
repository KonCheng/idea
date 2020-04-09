package com.koncheng.concurrent;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::browseNews).start();
        new Thread(TryConcurrency::listenMusic).start();
        new Thread().run();
//        listenMusic();
    }

    public static void browseNews() {
        for (; ; ) {
            System.out.println("good news");
            sleep(1);
        }
    }

    public static void listenMusic() {
        for (; ; ) {
            System.out.println("good music");
            sleep(1);
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
