package com.koncheng.dispatch.web;

import com.alibaba.fastjson.JSONObject;
import com.koncheng.dispatch.exception.AuthorizationException;
import com.koncheng.dispatch.exception.DataValidateException;
import com.koncheng.dispatch.exception.DispatchException;
import com.koncheng.dispatch.service.DispatchService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author KonCheng
 */
public class DispatchController {

    private DispatchService dispatchService = new DispatchService();

    public String proceed(Long taskId) throws DispatchException, AuthorizationException, DataValidateException {
        dispatchService.proceed(taskId);
        return "Succeed";
    }

    public String startProcess(HttpServletRequest request, JSONObject data) throws AuthorizationException, DispatchException, DataValidateException {
        dispatchService.startProcess(data);
        return "Succeed";
    }
}
