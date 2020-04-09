package com.koncheng.loader;

import java.util.HashMap;

public class Singleton {

    static {
        System.out.println("init");
        System.out.println(Singleton.x);
        x = 3;
    }

    public static int x;

    static {
        System.out.println(x);
    }

    private static Singleton instance = new Singleton();

    static {
        System.out.println(Singleton.x);
    }

    public static int y;

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
