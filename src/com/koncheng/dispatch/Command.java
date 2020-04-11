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
    void validate(Context context) throws DataValidateException;

    /**
     * 检查权限
     */
    void checkAccess(Context context) throws AuthorizationException;

    /**
     * 命令实现
     *
     * @param context
     * @return
     */
    T execute(Context context) throws DispatchException;
}
