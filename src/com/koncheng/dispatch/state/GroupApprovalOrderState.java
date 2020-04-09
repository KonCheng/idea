package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.order.GroupTaskOrder;

/**
 * 总部营销任务评审状态
 */
public class GroupApprovalOrderState extends GroupTaskOrderState {

    public static final int CODE = 0;
    public static final String NAME = "总部营销任务待评审";

    public GroupApprovalOrderState(GroupTaskOrder order) {
        super(order);
    }

    /**
     * 工单评审通过
     *
     * @param context
     */
    @Override
    public void approvalPass(Context context) {
        System.out.println("总部营销任务评审通过");
        super.order.setState(new GroupTaskProcessingOrderState(super.order));
    }

    /**
     * 工单评审驳回
     *
     * @param context
     */
    @Override
    public void approvalReject(Context context) {
        System.out.println("总部营销任务评审被驳回");
        super.order.setState(new StartUserHandleRejectOrderState(super.order));
    }

    /**
     * 工单重新提交
     *
     * @param context
     */
    @Override
    public void resubmit(Context context) {
        System.out.println("工单状态异常");
    }


    /**
     * 工单执行
     *
     * @param context
     */
    @Override
    public void execute(Context context) {
        System.out.println("工单状态异常");
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
    public void proceedWithCondition() {

    }

    /**
     * 保存当前工单状态
     */
    @Override
    public void persist() {
        System.out.println("当前状态保存至数据库");
    }
}
