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
    public abstract OrderState approvalPass(Context context);

    /**
     * 工单评审驳回
     */
    public abstract OrderState approvalReject(Context context);

    /**
     * 工单重新提交
     */
    public abstract OrderState resubmit(Context context);

    /**
     * 工单执行
     */
    public abstract OrderState execute(Context context);
}
