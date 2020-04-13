package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.manager.UserTaskManager;
import com.koncheng.dispatch.order.Order;

import java.util.Map;

public abstract class OrderState<T extends Order> {

    protected T order;

    public OrderState(T order) {
        this.order = order;
    }

    /**
     * 获取工单状态编号
     *
     * @return
     */
    public abstract int getCode();

    /**
     * 获取工单状态名称
     *
     * @return
     */
    public abstract String getName();

    public void proceed(String flowCondition, Context context) {
        Map<String, Object> dataMap = context.getData();
        System.out.println("进行业务处理，并获取下一阶段工单状态");
        // 进行业务处理，并获取下一阶段工单状态
        OrderState nextState = this.proceedWithCondition(flowCondition, context);

        // 处理用户任务
        new UserTaskManager().completeTask((Long) dataMap.get("taskId"));
        // 生成新的待办
        if (nextState != null) {
            nextState.generateUserTask();
        }
    }

    /**
     * 进行业务处理，并获取下一阶段工单状态
     *
     * @param flowCondition
     * @param context
     * @return 下一阶段工单状态
     */
    public abstract OrderState proceedWithCondition(String flowCondition, Context context);

    /**
     * 保存当前工单状态
     */
    public abstract void persist();

    public abstract void generateUserTask();
}
