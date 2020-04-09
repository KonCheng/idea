package com.koncheng.concurrent;

import java.util.ArrayList;

public class ThreadGroupCreator {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("");
        threadGroup.enumerate(new Thread[5]);
        Thread thread;
    }
}
