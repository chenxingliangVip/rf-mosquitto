package com.cn.manage.api;


import com.cn.manage.domain.Login;

import java.util.List;

public interface ILoginService {

    List<Login> queryAllLoginList() throws Exception;

    List<Login> queryLoginList(Login login) throws Exception;

    Login queryLogin(Login login) throws Exception;

    Boolean addUser(Login login) throws Exception;

}
