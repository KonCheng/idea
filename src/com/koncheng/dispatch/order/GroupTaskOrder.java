package com.koncheng.dispatch.order;

import com.koncheng.dispatch.state.GroupApprovalOrderState;
import com.koncheng.dispatch.state.GroupTaskOrderState;
import com.koncheng.dispatch.state.OrderState;

/**
 * 总部营销任务工单
 *
 * @author unicom
 */
public class GroupTaskOrder extends Order {

    private static final String TYPE = OrderType.GroupTask.name();

    public GroupTaskOrder(GroupTaskOrderState currentState) {
        super(currentState);
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

    @Override
    public GroupApprovalOrderState initialState() {
        return new GroupApprovalOrderState(this);
    }
}
