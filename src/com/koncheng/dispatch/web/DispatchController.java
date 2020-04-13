package com.koncheng.dispatch.web;

import com.alibaba.fastjson.JSONObject;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.User;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.service.DispatchService;

/**
 * @author KonCheng
 */
public class DispatchController {

    private static DispatchService dispatchService = new DispatchService();

    public String proceed(Long taskId) throws DispatchException, AuthorizationException, DataValidateException {
        dispatchService.proceed(taskId);
        return "Succeed";
    }

    public static String startProcess(JSONObject data) throws AuthorizationException, DispatchException, DataValidateException {
        System.out.println("收到发起营销任务请求，开始处理...");
        User currentUser = new User(1, 2);
        Context.setCurrentUser(currentUser);
        System.out.println("获取当前登录用户信息，用户id为：" + currentUser.id);
        dispatchService.startProcess(data);
        System.out.println("请求处理完成");
        return "Succeed";
    }

    public static String groupApproval(long taskId, long orderId, String comment, String flowCondition) throws AuthorizationException, DispatchException, DataValidateException {
        System.out.println("收到集团营销任务处理请求，开始处理...");
        User currentUser = new User(1, 2);
        Context.setCurrentUser(currentUser);
        System.out.println("获取当前登录用户信息，用户id为：" + currentUser.id);

        dispatchService.groupApproval(orderId, taskId, comment, flowCondition);
        System.out.println("请求处理完成");
        return "Succeed";
    }

    public static void main(String[] args) throws AuthorizationException, DispatchException, DataValidateException {
        /*JSONObject data = new JSONObject();
        data.put("name", "集团营销任务工单");
        data.put("type", "1");
        startProcess(data);*/
        groupApproval(1, 1, "", "pass");
    }
}
