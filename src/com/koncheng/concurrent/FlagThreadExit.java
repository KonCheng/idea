package com.koncheng.concurrent;

import java.util.concurrent.TimeUnit;

public class FlagThreadExit {
    static class MyTask extends Thread {
        private volatile boolean exit = false;

        @Override
        public void run() {
            while (!exit && !isInterrupted()) {
                System.out.println("running");
            }
            throw new RuntimeException();
        }

        public void exit() {
            this.exit = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        myTask.start();

        TimeUnit.SECONDS.sleep(2);

        myTask.exit();
    }
}
