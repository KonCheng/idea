package com.koncheng.concurrent;

import java.util.HashMap;

/**
 * 运行此方法会造成系统卡顿，有可能会丢失未保存的工作，请谨慎操作！
 */
public class HashMapDeadLock {
    private final HashMap<String, String> map = new HashMap<>();

    public void add(String key, String value) {
        this.map.put(key, value);
    }

    public long size() {
        return this.map.size();
    }

    /**
     * 运行此方法会造成系统卡顿，有可能会丢失未保存的工作，请谨慎操作！
     */
    public static void main(String[] args) {
        final HashMapDeadLock lock = new HashMapDeadLock();
        for (int x = 0; x < 2; x++) {
            new Thread(() -> {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    lock.add(String.valueOf(i), String.valueOf(i));
//                    System.out.println(lock.size());
                }
            }).start();
        }
    }
}
