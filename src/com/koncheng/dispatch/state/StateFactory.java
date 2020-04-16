package com.koncheng.dispatch.state;

import com.koncheng.dispatch.order.GroupTaskOrder;
import com.koncheng.dispatch.order.Order;

public class StateFactory {

    public static <T extends Order> GroupTaskOrderState toOrderState(T order, int status) {
        System.out.println("通过数据库工单数据对象和当前工单状态转成状态机工单状态对象");
        if (!(order instanceof GroupTaskOrder)) {
            return null;
        }
        GroupApprovalOrderState state = new GroupApprovalOrderState((GroupTaskOrder) order);
        return state;
    }
}
