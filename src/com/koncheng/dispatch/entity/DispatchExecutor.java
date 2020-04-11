package com.koncheng.dispatch.entity;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchExecutor {
    public long id;
    public long taskId;
    public long parentOrderId;
    public int type;
    public long orderId;

    public static final int EXECUTOR_DEPT_TYPE = 0;
    public static final int EXECUTOR_USER_TYPE = 1;

}
