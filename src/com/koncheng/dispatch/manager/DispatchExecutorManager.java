package com.koncheng.dispatch.manager;

import com.koncheng.dispatch.entity.DispatchExecutor;

public class DispatchExecutorManager {
    private static int id = 1;

    public DispatchExecutor save(DispatchExecutor executor) {
        System.out.println("执行单位保存成功");
        return executor;
    }

    public DispatchExecutor findById(Long id) {
        DispatchExecutor executor = new DispatchExecutor();
        executor.id = id;
        return executor;
    }

    public DispatchExecutor newAndSave(long taskId, long parentOrderId, int type) {
        DispatchExecutor executor = this.newExecutorObject(taskId, parentOrderId, type);
        executor.id = nextId();

        System.out.println("保存执行单位到数据库");
        this.save(executor);

        return executor;
    }

    public DispatchExecutor newExecutorObject(long taskId, long parentOrderId, int type) {
        System.out.println("新建执行单位数据对象");
        DispatchExecutor executor = new DispatchExecutor();
        executor.taskId = taskId;
        executor.parentOrderId = parentOrderId;
        executor.type = type;
        return executor;
    }

    private static synchronized int nextId() {
        return id++;
    }
}
