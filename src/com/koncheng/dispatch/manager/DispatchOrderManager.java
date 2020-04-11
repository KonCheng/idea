package com.koncheng.dispatch.manager;

import com.koncheng.dispatch.entity.DispatchOrder;
import com.koncheng.dispatch.order.GroupTaskOrder;
import com.koncheng.dispatch.order.OrderType;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchOrderManager {
    private static int id = 1;

    public DispatchOrder save(DispatchOrder order) {
        System.out.println("保存工单成功");
        return order;
    }

    public DispatchOrder findById(Long id) {
        DispatchOrder order = new DispatchOrder();
        order.id = id;
        return order;
    }

    public DispatchOrder newGroupTaskOrder(Long taskId) {
        System.out.println("新建集团营销任务工单数据实体对象");
        DispatchOrder order = new DispatchOrder();
        order.id = nextId();
        order.taskId = taskId;
        order.type = OrderType.GroupTask.name();
        order.status = new GroupTaskOrder(null).initialState().getCode();
        order.number = String.valueOf(order.id);

        System.out.println("保存集团营销任务工单到数据库");
        this.save(order);
        return order;
    }

    private static synchronized int nextId() {
        return id++;
    }
}
