package com.koncheng.dispatch;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;

/**
 * 命令接口
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public interface Command<T> {

    /**
     * 字段验证
     */
    void validate() throws DataValidateException;

    /**
     * 检查权限
     */
    void checkAccess() throws AuthorizationException;

    /**
     * 命令实现
     *
     * @return
     * @param context
     */
    T execute(Context context) throws DispatchException;
}
