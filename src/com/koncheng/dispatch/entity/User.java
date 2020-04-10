package com.koncheng.dispatch.entity;

/**
 * @author ChenYong
 * @version 2020-4-10
 */
public class User {
    public long id;
    public long deptId;

    public User() {
    }

    public User(long id, long deptId) {
        this.id = id;
        this.deptId = deptId;
    }
}
