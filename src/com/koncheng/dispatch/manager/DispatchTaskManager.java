package com.koncheng.dispatch.manager;

import com.koncheng.dispatch.entity.DispatchTask;

/**
 * 营销任务Manager
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchTaskManager {
    DispatchTask save(DispatchTask task) {
        System.out.println("Task保存成功");
        return task;
    }

    DispatchTask findById(Long id) {
        DispatchTask task = new DispatchTask();
        task.id = id;
        return task;
    }
}
