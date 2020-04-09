package com.koncheng.vola;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {
    final static int MAX = 5;
    static volatile int initValue = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                if (initValue != localValue) {
                    System.out.printf("the initValue is updated to [%d]\n", initValue);
                    localValue = initValue;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                System.out.printf("the initValue will update to [%d]\n", ++localValue);
                initValue = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
