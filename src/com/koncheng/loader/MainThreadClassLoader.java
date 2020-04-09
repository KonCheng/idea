package com.koncheng.loader;

import static java.lang.Thread.currentThread;

public class MainThreadClassLoader {

    public static void main(String[] args) {

        System.out.println(currentThread().getName() + currentThread().getContextClassLoader());
        new Thread(() -> System.out.println(currentThread().getName() + currentThread().getContextClassLoader())).start();
    }
}
