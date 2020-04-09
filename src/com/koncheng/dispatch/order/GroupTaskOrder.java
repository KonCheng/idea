package com.koncheng.dispatch.order;

import com.koncheng.dispatch.entity.Context;

/**
 * 集团营销任务工单
 */
public interface GroupTaskOrder extends Order {

    /**
     * 工单评审通过
     */
    void approvalPass(Context context);

    /**
     * 工单评审驳回
     */
    void approvalReject(Context context);

    /**
     * 工单重新提交
     */
    void resubmit(Context context);

    /**
     * 工单执行
     */
    void execute(Context context);
}
