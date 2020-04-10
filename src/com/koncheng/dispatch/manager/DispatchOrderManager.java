package com.koncheng.dispatch.manager;

import com.koncheng.dispatch.entity.DispatchOrder;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchOrderManager {

    public DispatchOrder save(DispatchOrder order) {
        System.out.println("保存工单成功");
        return order;
    }

    public DispatchOrder findById(Long id) {
        DispatchOrder order = new DispatchOrder();
        order.id = id;
        return order;
    }
}
