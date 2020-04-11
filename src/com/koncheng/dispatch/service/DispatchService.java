package com.koncheng.dispatch.service;

import com.alibaba.fastjson.JSONObject;
import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.CommandExecutor;
import com.koncheng.dispatch.ICommandExecutor;
import com.koncheng.dispatch.command.StartTaskCmd;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.ContextBuilder;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;

/**
 * @author ChenYong
 */
public class DispatchService {

    private ICommandExecutor commandExecutor = new CommandExecutor();

    public void proceed(Long taskId) throws DispatchException, AuthorizationException, DataValidateException {

        String result = commandExecutor.execute(new Command<>() {
            @Override
            public void validate(Context context) {

            }

            @Override
            public void checkAccess(Context context) throws AuthorizationException {
                throw new AuthorizationException();
            }

            @Override
            public String execute(Context context) throws DispatchException {
                throw new DispatchException();
            }
        }, new ContextBuilder().build());
    }

    public String startProcess(JSONObject data) throws DispatchException, AuthorizationException, DataValidateException {
        System.out.println("开始构建Context对象");
        ContextBuilder builder = new ContextBuilder();
        builder.dataMap(data);
        System.out.println("开始处理创建营销任务命令");
        return commandExecutor.execute(new StartTaskCmd(), builder.build());
    }
}
