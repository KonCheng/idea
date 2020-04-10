package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.DispatchExecutor;
import com.koncheng.dispatch.entity.DispatchTargetClient;
import com.koncheng.dispatch.entity.DispatchTask;
import com.koncheng.dispatch.state.OrderState;

/**
 * 工单接口
 */
public abstract class Order {

    private OrderState currentState;

    public Order(OrderState currentState) {
        this.currentState = currentState;
    }

    /**
     * 获取工单类型
     *
     * @return
     */
    public abstract String getType();

    /**
     * 获取工单当前状态
     *
     * @return
     */
    public OrderState getState() {
        return this.currentState;
    }

    /**
     * 设置工单状态
     */
    public void setState(OrderState state) {
        this.currentState = state;
    }

    /**
     * 新建工单
     */
    public void start() {

    }

    public void start(DispatchTask task) {

    }

    public void start(DispatchExecutor executor) {

    }

    public void start(DispatchTargetClient client) {

    }

    /**
     * 保存工单
     */
    public void persist() {
    }

    /**
     * 工单执行
     *
     * @param flowCondition
     * @param context
     */
    public void proceedWithCondition(String flowCondition, Context context) {
        this.currentState.proceedWithCondition(flowCondition, context);
    }
}
