package com.koncheng.dispatch.command;

import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.User;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.observer.TaskStatisticObserver;
import com.koncheng.dispatch.order.GroupTaskOrder;
import com.koncheng.dispatch.order.Order;

import java.util.Observable;
import java.util.Observer;

/**
 * 发起营销任务命令
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class StartTaskCmd extends Observable implements Command<String> {

    private Observer taskStatisticObserver = new TaskStatisticObserver();

    public StartTaskCmd() {
        super.addObserver(taskStatisticObserver);
    }

    @Override
    public void validate() throws DataValidateException {

    }

    @Override
    public void checkAccess() throws AuthorizationException {
        User user = Context.getCurrentUser();
        if (user == null) {
            throw new AuthorizationException();
        }
    }

    @Override
    public String execute(Context context) throws DispatchException {

        // 新建营销任务
        // 保存营销任务数据
        // 保存执行单位
        // 保存营销要求及附件
        // 保存重点产品及附件
        // 保存目标客户
        // 保存其他执行人
        // 生成工单
        Order order = new GroupTaskOrder(null);
        order.start();

        try {
            super.setChanged();
            super.notifyObservers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
