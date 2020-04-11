package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.DispatchOrder;
import com.koncheng.dispatch.state.GroupApprovalOrderState;

public class OrderFactory {

    public static Order toOrder(DispatchOrder order) {

        GroupTaskOrder groupTaskOrder = null;
        groupTaskOrder = new GroupTaskOrder(new GroupApprovalOrderState(null));
        return groupTaskOrder;
    }
}
