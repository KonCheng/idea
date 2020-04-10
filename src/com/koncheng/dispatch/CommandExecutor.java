package com.koncheng.dispatch;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;

/**
 * 命令执行器
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class CommandExecutor implements ICommandExecutor {

    /**
     * 执行命令
     * 1. 检查权限
     * 2. 执行命令
     *
     * @param <T>
     * @param command
     * @param context
     * @return
     * @throws AuthorizationException 用户权限不足时抛出此异常
     * @throws DispatchException      派单流程业务异常
     */
    @Override
    public <T> T execute(Command<T> command, Context context) throws AuthorizationException, DispatchException, DataValidateException {
        command.validate();
        command.checkAccess();
        return command.execute(context);
    }
}
