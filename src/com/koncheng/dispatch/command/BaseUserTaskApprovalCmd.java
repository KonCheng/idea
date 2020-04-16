package com.koncheng.dispatch.command;

import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.manager.UserTaskManager;

/**
 * @author ChenYong
 * @version 2020-4-13
 */
public abstract class BaseUserTaskApprovalCmd {

    protected void checkUserTask(long taskId) throws DispatchException {
        if (!new UserTaskManager().exist(taskId)) {
            throw new DispatchException();
        }
    }

    protected void checkUserTaskAccess(long taskId, long userId) throws AuthorizationException {
        if (!new UserTaskManager().checkAccess(taskId, userId)) {
            throw new AuthorizationException();
        }
    }
}
