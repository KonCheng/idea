package com.koncheng.dispatch.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 营销任务统计观察者
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class TaskStatisticObserver implements Observer {

    private static long taskCount = 0;

    @Override
    public void update(Observable o, Object arg) {
        count();
    }

    public static long getTaskNumber() {
        return taskCount;
    }

    private static synchronized void count() {
        taskCount++;
        System.out.printf("营销任务总数加1，当前共%d条。\n", taskCount);
    }
}
