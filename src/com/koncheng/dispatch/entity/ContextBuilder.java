package com.koncheng.dispatch.entity;

import java.util.List;
import java.util.Map;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public final class ContextBuilder {
    private final Context context = new Context();

    public Context build() {
        return context;
    }

    public ContextBuilder dispatchTask(DispatchTask task) {
        this.context.setDispatchTask(task);
        return this;
    }

    public ContextBuilder dispatchOrder(DispatchOrder order) {
        this.context.setDispatchOrder(order);
        return this;
    }

    public ContextBuilder dispatchOrders(List<DispatchOrder> orders) {
        this.context.setOrders(orders);
        return this;
    }

    public ContextBuilder dispatchExecutor(DispatchExecutor executor) {
        this.context.setExecutor(executor);
        return this;
    }

    public ContextBuilder dispatchExecutors(List<DispatchExecutor> executors) {
        this.context.setExecutors(executors);
        return this;
    }

    public ContextBuilder dispatchTargetClient(DispatchTargetClient client) {
        this.context.setClient(client);
        return this;
    }

    public ContextBuilder dispatchTargetClients(List<DispatchTargetClient> clients) {
        this.context.setClients(clients);
        return this;
    }

    public ContextBuilder dispatchLinkRequirement(DispatchLinkRequirement requirement) {
        this.context.setRequirement(requirement);
        return this;
    }

    public ContextBuilder dispatchLinkRequirements(List<DispatchLinkRequirement> requirements) {
        this.context.setRequirements(requirements);
        return this;
    }

    public ContextBuilder dataMap(Map<String, Object> data) {
        this.context.setData(data);
        return this;
    }


}
