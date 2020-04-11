package com.koncheng.dispatch.manager;

import com.koncheng.dispatch.entity.DispatchTask;

/**
 * 营销任务Manager
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchTaskManager {
    private static int id = 1;

    public DispatchTask save(DispatchTask task) {
        System.out.println("营销任务保存成功");
        return task;
    }

    public DispatchTask findById(Long id) {
        DispatchTask task = new DispatchTask();
        task.id = id;
        return task;
    }

    public DispatchTask newAndSave(String name, String type, Long userId) {
        DispatchTask task = this.newTaskObject(name, type, userId);
        task.id = nextId();

        System.out.println("保存营销任务数据到数据库");
        this.save(task);
        return task;
    }

    public DispatchTask newTaskObject(String name, String type, Long userId) {
        System.out.println("创建营销任务数据实体对象");
        DispatchTask task = new DispatchTask();
        task.name = name;
        task.type = type;
        task.creator = userId;
        return task;
    }

    private static synchronized int nextId() {
        return id++;
    }

}
