package com.koncheng.concurrent;

public class DeadLock {
    private static final Object READ_LOCK = new Object();
    private static final Object WRITE_LOCK = new Object();

    private void read() {
        synchronized (READ_LOCK) {
            System.out.println("Read method get READ_LOCK");
            synchronized (WRITE_LOCK) {
                System.out.println("Read method get WRITE_LOCK");
            }
            System.out.println("Read method release WRITE_LOCK");
        }
        System.out.println("Read method release READ_LOCK");
    }

    private void write() {
        synchronized (WRITE_LOCK) {
            System.out.println("Write method get WRITE_LOCK");
            synchronized (READ_LOCK) {
                System.out.println("Write method get READ_LOCK");
            }
            System.out.println("Write method release READ_LOCK");
        }
        System.out.println("Write method release WRITE_LOCK");
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) deadLock.read();
        }).start();
        new Thread(() -> {
            while (true) deadLock.write();
        }).start();
    }
}
