package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.*;
import com.koncheng.dispatch.manager.DispatchOrderManager;
import com.koncheng.dispatch.state.GroupApprovalOrderState;
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

    public static Order start(DispatchTask task) {
        System.out.println("开始生成营销任务工单");
        DispatchOrderManager orderManager = new DispatchOrderManager();


        DispatchOrder order = orderManager.newGroupTaskOrder(task.id);

        System.out.println("工单创建成功");
        return OrderFactory.toOrder(order);
    }

    public static Order start(DispatchExecutor executor) {
        return null;
    }

    public static Order start(DispatchTargetClient client) {
        return null;
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

    public abstract GroupApprovalOrderState initialState();

}
