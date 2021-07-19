package com.cn.manage.api;
import com.cn.manage.domain.ActionPermission;
import com.cn.manage.domain.Role;

import java.util.List;

public interface IPermissionService {

    List<Role> queryAllRoles(String roleName) throws Exception;

    List<String> queryRolePermission(String userAccount)throws Exception;

    List<String> queryPermissionByRoleId(String roleId)throws Exception;

    List<ActionPermission> queryActionPermission() throws Exception;

    boolean addPermission(Role role)throws Exception;

    boolean deleteRole(String id)throws Exception;

    boolean updatePermission(Role role)throws Exception;
}
