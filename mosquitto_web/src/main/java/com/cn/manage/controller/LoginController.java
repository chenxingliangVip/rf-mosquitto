package com.cn.manage.controller;

import com.cn.manage.api.ILoginService;
import com.cn.manage.domain.Login;
import com.cn.manage.util.ClientMQTT;
import com.cn.manage.utils.JsonResponse;
import com.cn.manage.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private ClientMQTT clientMQTT;

    @RequestMapping("/")
    public String home() {
        return "redirect:index";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/index.html";
    }

    @ResponseBody
    @RequestMapping("/login")
    public JsonResponse<Login> login(Login login) throws Exception {
        JsonResponse<Login> response = new JsonResponse<Login>();
        if(StringUtils.isNotBlank(login.getPassword())){
            login.setPassword(MD5Util.MD5(login.getPassword()));
        }
        clientMQTT.start();
        return response;
    }


}
