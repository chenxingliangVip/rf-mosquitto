package com.cn.manage.controller;

import com.cn.manage.api.IPermissionService;
import com.cn.manage.domain.ActionPermission;
import com.cn.manage.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    IPermissionService permissionService;

    @RequestMapping("/queryRolePermission")
    @ResponseBody
    public JsonResponse<List<String>> queryRolePermission(String userAccount) throws Exception {
        JsonResponse<List<String>> response = new JsonResponse<List<String>>();
        List<String> list  = permissionService.queryRolePermission(userAccount);
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

    @RequestMapping("/queryActionPermission")
    @ResponseBody
    public JsonResponse<List<ActionPermission>> queryActionPermission() throws Exception {
        JsonResponse<List<ActionPermission>> response = new JsonResponse<List<ActionPermission>>();
        List<ActionPermission> list  = permissionService.queryActionPermission();
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

}
