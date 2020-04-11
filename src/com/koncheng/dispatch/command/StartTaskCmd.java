package com.koncheng.dispatch.command;

import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.DispatchTask;
import com.koncheng.dispatch.entity.User;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.manager.DispatchExecutorManager;
import com.koncheng.dispatch.manager.DispatchTaskManager;
import com.koncheng.dispatch.observer.TaskStatisticObserver;
import com.koncheng.dispatch.order.Order;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import static com.koncheng.dispatch.entity.DispatchExecutor.EXECUTOR_DEPT_TYPE;

/**
 * 发起营销任务命令
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class StartTaskCmd extends Observable implements Command<String> {

    private String name;
    private String type;
    private Long userId;

    private Observer taskStatisticObserver = new TaskStatisticObserver();

    public StartTaskCmd() {
        super.addObserver(taskStatisticObserver);
    }

    @Override
    public void validate(Context context) throws DataValidateException {
        System.out.println("进行数据校验");
        Map<String, Object> dataMap = context.getData();
        this.name = (String) dataMap.get("name");
        this.type = (String) dataMap.get("type");
        if (this.name == null) {
            throw new DataValidateException();
        }
        if (this.type == null) {
            throw new DataValidateException();
        }
    }

    @Override
    public void checkAccess(Context context) throws AuthorizationException {
        System.out.println("进行操作权限校验");
        User user = Context.getCurrentUser();
        if (user == null) {
            throw new AuthorizationException();
        }
        this.userId = user.id;
    }

    @Override
    public String execute(Context context) throws DispatchException {

        // 新建营销任务
        // 保存营销任务数据
        DispatchTask task = new DispatchTaskManager().newAndSave(this.name, this.type, this.userId);
        // 保存执行单位
        new DispatchExecutorManager().newAndSave(task.id, 0, EXECUTOR_DEPT_TYPE);
        // 保存营销要求及附件

        // 保存重点产品及附件

        // 保存目标客户

        // 保存其他执行人

        // 生成工单
        Order.start(task);

        try {
            System.out.println("通知观察者，记录统计数据");
            super.setChanged();
            super.notifyObservers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
