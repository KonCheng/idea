package com.koncheng.concurrent;

public class TicketWindow2 implements Runnable {
    private int index = 1;

    private static final int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + Thread.currentThread() + "当前号码为：" + index++);
        }
    }
}
