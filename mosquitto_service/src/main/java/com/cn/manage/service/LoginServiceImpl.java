package com.cn.manage.service;

import com.cn.manage.api.ILoginService;
import com.cn.manage.dao.LoginMapper;
import com.cn.manage.domain.Login;
import com.cn.manage.utils.CommonUtil;
import com.cn.manage.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> queryAllLoginList() throws Exception {
        return null;
    }

    @Override
    public List<Login> queryLoginList(Login login) throws Exception {
        return null;
    }

    @Override
    public Login queryLogin(Login login) throws Exception {
        return null;
    }

    @Override
    public Boolean addUser(Login login) throws Exception {
        login.setId(CommonUtil.generateRandomNum("login-"));
        login.setPassword(MD5Util.MD5(login.getPassword()));
        int count =  loginMapper.insertSelective(login);
        return count > 0;
    }
}
