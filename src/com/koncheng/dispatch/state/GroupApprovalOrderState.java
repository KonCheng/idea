package com.koncheng.dispatch.state;

import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.order.GroupTaskOrder;

/**
 * 总部营销任务评审状态
 *
 * @author unicom
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
    public OrderState approvalPass(Context context) {
        System.out.println("总部营销任务评审通过");
        OrderState<GroupTaskOrder> orderState = new GroupTaskProcessingOrderState(super.order);
//        ((GroupTaskProcessingOrderState) orderState).execute();
        super.order.setState(orderState);
        return orderState;
    }

    /**
     * 工单评审驳回
     *
     * @param context
     */
    @Override
    public OrderState approvalReject(Context context) {
        System.out.println("总部营销任务评审被驳回");
        StartUserHandleRejectOrderState orderState = new StartUserHandleRejectOrderState(super.order);
        super.order.setState(orderState);
        return orderState;
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
     * 工单执行
     *
     * @param context
     */
    @Override
    public OrderState execute(Context context) {
        System.out.println("工单状态异常");
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
        switch (flowCondition) {
            case "pass":
                return this.approvalPass(context);
            case "reject":
                return this.approvalReject(context);
        }
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
        System.out.println("生成待办");
    }
}
