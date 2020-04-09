package com.koncheng.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreads {

    public static void main(String[] args) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, () -> {
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        currentGroup.list();
    }
}
