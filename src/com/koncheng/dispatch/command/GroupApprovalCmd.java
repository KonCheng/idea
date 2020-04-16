package com.koncheng.dispatch.command;

import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.DispatchOrder;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.manager.DispatchOrderManager;
import com.koncheng.dispatch.order.Order;
import com.koncheng.dispatch.order.OrderFactory;

import java.util.Map;

/**
 * 集团营销任务评审命令
 *
 * @author ChenYong
 * @version 2020-4-13
 */
public class GroupApprovalCmd extends BaseUserTaskApprovalCmd implements Command<String> {

    private long taskId;
    private long orderId;
    private long userId;
    private String comment;
    private String flowCondition;

    @Override
    public void validate(Context context) throws DataValidateException {
        System.out.println("进行数据校验");

        Map<String, Object> dataMap = context.getData();
        this.taskId = (long) dataMap.get("taskId");
        this.orderId = (long) dataMap.get("orderId");
        this.comment = (String) dataMap.get("comment");
        this.flowCondition = (String) dataMap.get("flowCondition");
        if (this.comment == null) {
            throw new DataValidateException();
        }
    }

    @Override
    public void checkAccess(Context context) throws AuthorizationException {
        System.out.println("进行操作权限校验");

        this.userId = Context.getCurrentUser().id;
        if (this.userId == 0) {
            throw new AuthorizationException();
        }
        super.checkUserTaskAccess(this.taskId, this.userId);
    }

    @Override
    public String execute(Context context) throws DispatchException {

        // 从数据库获取工单对象
        DispatchOrder order = new DispatchOrderManager().findById(this.orderId);
        if (order == null) {
            throw new DispatchException();
        }
        context.setDispatchOrder(order);

        // 通过OrderFactory创建Order对象，交状态机处理
        Order order1 = OrderFactory.toOrder(order);
        order1.proceedWithCondition(flowCondition, context);
        return null;
    }
}
