package com.koncheng.dispatch.entity;

/**
 * 工单实体类
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class DispatchOrder {
    public long id;
    public long taskId;
    public String type;
    public String number;
    public int status;
    public long parentOrderId;
    public long rootOrderId;
    public long provinceOrderId;
    public long cityOrderId;
    public long custMgrOrderId;
}
