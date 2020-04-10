package com.koncheng.dispatch.entity;

import java.util.List;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public final class ContextBuilder {
    private Context context = new Context();

    Context build() {
        return context;
    }

    ContextBuilder dispatchTask(DispatchTask task) {
        this.context.setDispatchTask(task);
        return this;
    }

    ContextBuilder dispatchOrder(DispatchOrder order) {
        this.context.setDispatchOrder(order);
        return this;
    }

    ContextBuilder dispatchOrders(List<DispatchOrder> orders) {
        this.context.setOrders(orders);
        return this;
    }

    ContextBuilder dispatchExecutor(DispatchExecutor executor) {
        this.context.setExecutor(executor);
        return this;
    }

    ContextBuilder dispatchExecutors(List<DispatchExecutor> executors) {
        this.context.setExecutors(executors);
        return this;
    }
}
