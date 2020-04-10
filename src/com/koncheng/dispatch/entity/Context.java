package com.koncheng.dispatch.entity;

/**
 * @author ChenYong
 */
public class Context {
    public User user;
    public DispatchTask task;
    private static final ThreadLocal<User> currentUserThreadLocal = new ThreadLocal<>();

    public static User getCurrentUser() {
        return currentUserThreadLocal.get();
    }

    public static void setCurrentUser(User user) {
        currentUserThreadLocal.set(user);
    }
}
