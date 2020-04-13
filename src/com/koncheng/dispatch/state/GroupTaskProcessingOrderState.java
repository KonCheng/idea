package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.order.GroupTaskOrder;

public class GroupTaskProcessingOrderState extends GroupTaskOrderState {

    public static final int CODE = 1;
    public static final String NAME = "总部营销任务处理中";

    public GroupTaskProcessingOrderState(GroupTaskOrder order) {
        super(order);
    }

    /**
     * 工单评审通过
     *
     * @param context
     */
    @Override
    public OrderState approvalPass(Context context) {
        System.out.println("工单状态异常");
        return null;
    }

    /**
     * 工单评审驳回
     *
     * @param context
     */
    @Override
    public OrderState approvalReject(Context context) {
        System.out.println("工单状态异常");
        return null;
    }

    /**
     * 工单重新提交
     *
     * @param context
     */
    @Override
    public OrderState resubmit(Context context) {
        System.out.println("工单状态异常");
        return null;
    }

    /**
     * 工单执行，拆单
     *
     * @param context
     */
    @Override
    public OrderState execute(Context context) {
        System.out.println("工单处理中");
        System.out.println("产生新的子工单");
        System.out.println("保存新的子工单");
        return null;
    }

    /**
     * 获取工单状态编号
     *
     * @return
     */
    @Override
    public int getCode() {
        return CODE;
    }

    /**
     * 获取工单状态名称
     *
     * @return
     */
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public OrderState proceedWithCondition(String flowCondition, Context context) {
        return null;
    }

    /**
     * 保存当前工单状态
     */
    @Override
    public void persist() {
        System.out.println("当前状态保存至数据库");
    }

    @Override
    public void generateUserTask() {
        execute(null);
        System.out.println("生成用户任务");
    }
}
