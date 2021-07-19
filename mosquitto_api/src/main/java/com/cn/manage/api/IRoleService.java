package com.cn.manage.api;



import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> queryRoleList()throws Exception;

    Boolean deleteRole(QueryForm queryForm) throws Exception;

    Boolean addRole(Role role) throws Exception;

    Boolean updateRole(Role role) throws Exception;
}
