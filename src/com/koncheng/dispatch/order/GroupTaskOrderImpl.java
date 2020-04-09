package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.state.GroupTaskOrderState;
import com.koncheng.dispatch.state.OrderState;

/**
 * 总部营销任务工单
 */
public class GroupTaskOrderImpl implements GroupTaskOrder {

    private static final String TYPE = OrderType.GroupTask.name();

    private GroupTaskOrderState currentState;

    public GroupTaskOrderImpl(GroupTaskOrderState currentState) {
        this.currentState = currentState;
    }

    /**
     * 工单评审通过
     *
     * @param context
     */
    @Override
    public void approvalPass(Context context) {
        currentState.approvalPass(context);
    }

    /**
     * 工单评审驳回
     *
     * @param context
     */
    @Override
    public void approvalReject(Context context) {
        currentState.approvalReject(context);
    }

    /**
     * 工单重新提交
     *
     * @param context
     */
    @Override
    public void resubmit(Context context) {
        currentState.resubmit(context);
    }

    /**
     * 工单执行
     *
     * @param context
     */
    @Override
    public void execute(Context context) {
        currentState.execute(context);
    }

    /**
     * 获取工单类型
     *
     * @return
     */
    @Override
    public String getType() {
        return TYPE;
    }

    /**
     * 获取工单当前状态
     *
     * @return
     */
    @Override
    public GroupTaskOrderState getState() {
        return currentState;
    }

    /**
     * 设置工单状态
     */
    @Override
    public void setState(OrderState state) {
        if (state instanceof GroupTaskOrderState) {
            this.currentState = (GroupTaskOrderState) state;
        }
    }

    /**
     * 工单执行
     *
     * @param flowCondition
     * @param context
     */
    @Override
    public void proceedWithCondition(String flowCondition, Context context) {
        currentState.proceedWithCondition();
    }
}
