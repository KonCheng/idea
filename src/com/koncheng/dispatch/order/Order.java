package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.state.GroupTaskOrderState;
import com.koncheng.dispatch.state.OrderState;

/**
 * 工单接口
 */
public interface Order {
    /**
     * 获取工单类型
     *
     * @return
     */
    String getType();

    /**
     * 获取工单当前状态
     *
     * @return
     */
    OrderState getState();

    /**
     * 设置工单状态
     */
    void setState(OrderState state);

    /**
     * 工单执行
     *
     * @param flowCondition
     * @param context
     */
    void proceedWithCondition(String flowCondition, Context context);
}
