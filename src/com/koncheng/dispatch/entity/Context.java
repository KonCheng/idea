package com.koncheng.dispatch.entity;

import java.util.List;

/**
 * @author ChenYong
 */
public class Context {
    private static final ThreadLocal<User> currentUserThreadLocal = new ThreadLocal<>();

    private DispatchTask dispatchTask;

    private DispatchOrder dispatchOrder;

    private List<DispatchOrder> orders;

    private DispatchExecutor executor;

    private List<DispatchExecutor> executors;

    private DispatchTargetClient client;

    private List<DispatchTargetClient> clients;

    private DispatchLinkRequirement requirement;

    private List<DispatchLinkRequirement> requirements;

    public static User getCurrentUser() {
        return currentUserThreadLocal.get();
    }

    public static void setCurrentUser(User user) {
        currentUserThreadLocal.set(user);
    }

    public DispatchTask getDispatchTask() {
        return dispatchTask;
    }

    public void setDispatchTask(DispatchTask dispatchTask) {
        this.dispatchTask = dispatchTask;
    }

    public DispatchOrder getDispatchOrder() {
        return dispatchOrder;
    }

    public void setDispatchOrder(DispatchOrder dispatchOrder) {
        this.dispatchOrder = dispatchOrder;
    }

    public List<DispatchOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<DispatchOrder> orders) {
        this.orders = orders;
    }

    public DispatchExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(DispatchExecutor executor) {
        this.executor = executor;
    }

    public List<DispatchExecutor> getExecutors() {
        return executors;
    }

    public void setExecutors(List<DispatchExecutor> executors) {
        this.executors = executors;
    }

    public DispatchTargetClient getClient() {
        return client;
    }

    public void setClient(DispatchTargetClient client) {
        this.client = client;
    }

    public List<DispatchTargetClient> getClients() {
        return clients;
    }

    public void setClients(List<DispatchTargetClient> clients) {
        this.clients = clients;
    }

    public DispatchLinkRequirement getRequirement() {
        return requirement;
    }

    public void setRequirement(DispatchLinkRequirement requirement) {
        this.requirement = requirement;
    }

    public List<DispatchLinkRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<DispatchLinkRequirement> requirements) {
        this.requirements = requirements;
    }
}
