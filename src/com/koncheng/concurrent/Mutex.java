package com.koncheng.concurrent;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Mutex {

    private final static Object MUTEX = new Object();

    public void accessResources() {
        synchronized (MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, 1);
    }
}
