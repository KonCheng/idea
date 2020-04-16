package com.koncheng.dispatch.manager;

/**
 * 用户任务（待办）Manager
 *
 * @author ChenYong
 * @version 2020-4-13
 */
public class UserTaskManager {

    /**
     * 判断待办是否存在
     *
     * @param taskId
     * @return
     */
    public boolean exist(long taskId) {
        System.out.println("判断任务是否存在？存在！");
        return true;
    }

    /**
     * 检查当前用户是否有当前待办的处理权限
     *
     * @param taskId
     * @param userId
     * @return
     */
    public boolean checkAccess(long taskId, long userId) {
        if (exist(taskId)) {
            System.out.println("检查用户是否有待办的操作权限？有权限操作！");
            return true;
        }
        return false;
    }

    public void completeTask(long taskId) {
        System.out.println("处理待办");
    }
}
