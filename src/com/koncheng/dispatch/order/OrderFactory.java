package com.koncheng.dispatch.order;

public interface OrderFactory {

    Order getOrder(Long taskId);
}
