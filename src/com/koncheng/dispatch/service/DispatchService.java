package com.koncheng.dispatch.service;

import com.alibaba.fastjson.JSONObject;
import com.koncheng.dispatch.Command;
import com.koncheng.dispatch.CommandExecutor;
import com.koncheng.dispatch.ICommandExecutor;
import com.koncheng.dispatch.command.StartTaskCmd;
import com.koncheng.dispatch.entity.Context;
import com.koncheng.dispatch.entity.User;
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
            public void validate() {

            }

            @Override
            public void checkAccess() throws AuthorizationException {
                throw new AuthorizationException();
            }

            @Override
            public String execute(Context context) throws DispatchException {
                throw new DispatchException();
            }
        }, new Context());
    }

    public String startProcess(JSONObject data) throws DispatchException, AuthorizationException, DataValidateException {
        Context context = new Context();
        return commandExecutor.execute(new StartTaskCmd(), context);
    }
}
