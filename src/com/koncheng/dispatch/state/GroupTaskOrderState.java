package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.order.GroupTaskOrder;

public abstract class GroupTaskOrderState extends OrderState<GroupTaskOrder> {

    public GroupTaskOrderState(GroupTaskOrder order) {
        super(order);
    }

    /**
     * 工单评审通过
     */
    public abstract void approvalPass(Context context);

    /**
     * 工单评审驳回
     */
    public abstract void approvalReject(Context context);

    /**
     * 工单重新提交
     */
    public abstract void resubmit(Context context);

    /**
     * 工单执行
     */
    public abstract void execute(Context context);
}
