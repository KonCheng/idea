package com.koncheng.dispatch.command;

import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;

/**
 * 发起营销任务命令
 *
 * @author ChenYong
 * @version 2020-4-10
 */
public class StartTaskCmd implements Command<String> {

    @Override
    public void validate() throws DataValidateException {

    }

    @Override
    public void checkAccess() throws AuthorizationException {

    }

    @Override
    public String execute() throws DispatchException {
        // 保存营销任务数据
        // 保存执行单位
        // 保存营销要求及附件
        // 保存重点产品及附件
        // 保存目标客户
        // 保存其他执行人
        // 生成工单
        return null;
    }
}
