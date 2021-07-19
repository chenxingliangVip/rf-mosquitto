package com.cn.manage.service;

import com.cn.manage.api.ILoginService;
import com.cn.manage.dao.LoginMapper;
import com.cn.manage.domain.Login;
import com.cn.manage.domain.LoginExample;
import com.cn.manage.util.Constants;
import com.cn.manage.utils.CollectionsUtil;
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
        LoginExample example = new LoginExample();
        example.createCriteria()
                .andStatusEqualTo(Constants.NORMAL_STATUS)
                .andUserAccountEqualTo(login.getUserAccount());
        List<Login> loginList = loginMapper.selectByExample(example);
        if(CollectionsUtil.isEmpty(loginList) || loginList.size() !=1){
            throw new Exception("查询用户出现异常！");
        }
        Login result = loginList.get(0);
        return result;
    }

    @Override
    public Boolean addUser(Login login) throws Exception {
        login.setId(CommonUtil.generateRandomNum("login-"));
        login.setPassword(MD5Util.MD5(login.getPassword()));
        int count =  loginMapper.insertSelective(login);
        return count > 0;
    }
}
