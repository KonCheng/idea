package com.koncheng.concurrent;

public class TicketWindow extends Thread {

    private final String name;

    private static final int MAX = 500;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + this.name + "当前号码为：" + index++);
        }
    }
}
