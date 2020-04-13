package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.DispatchOrder;
import com.koncheng.dispatch.state.OrderState;
import com.koncheng.dispatch.state.StateFactory;

public class OrderFactory {

    public static Order toOrder(DispatchOrder order) {
        System.out.println("把数据库工单实体对象转换成状态机工单对象");
        GroupTaskOrder groupTaskOrder = new GroupTaskOrder();
        OrderState<GroupTaskOrder> orderState = StateFactory.toOrderState(groupTaskOrder, groupTaskOrder.getOrderObject().status);
        groupTaskOrder.setState(orderState);
        return groupTaskOrder;
    }
}
