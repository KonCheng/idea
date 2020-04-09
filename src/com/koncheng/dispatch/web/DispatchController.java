package com.koncheng.dispatch.web;

import com.koncheng.dispatch.service.DispatchService;

public class DispatchController {

    private DispatchService dispatchService = new DispatchService();


    public String proceed(Long taskId) {
        dispatchService.proceed(taskId);
        return "Succeed";
    }
}
