package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.order.Order;

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

    public abstract void proceedWithCondition(String flowCondition, Context context);

    /**
     * 保存当前工单状态
     */
    public abstract void persist();
}
