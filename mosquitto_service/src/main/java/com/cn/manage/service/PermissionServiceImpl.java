package com.cn.manage.service;

import com.cn.manage.api.IPermissionService;
import com.cn.manage.dao.ActionPermissionMapper;
import com.cn.manage.dao.RoleMapper;
import com.cn.manage.domain.ActionPermission;
import com.cn.manage.domain.ActionPermissionExample;
import com.cn.manage.domain.Role;
import com.cn.manage.domain.RoleExample;
import com.cn.manage.util.Constants;
import com.cn.manage.util.ConvertTree;
import com.cn.manage.utils.CollectionsUtil;
import com.cn.manage.utils.CommonUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ActionPermissionMapper actionPermissionMapper;


    @Override
    public List<Role> queryAllRoles(String userAccount) throws Exception {
        return null;
    }

    @Override
    public List<String> queryRolePermission(String userAccount) throws Exception {
        List<String> permissionList = Lists.newArrayList();
        return permissionList;
    }

    @Override
    public List<String> queryPermissionByRoleId(String roleId) throws Exception {
        return null;
    }

    @Override
    public List<ActionPermission> queryActionPermission() throws Exception {
        ActionPermissionExample example = new ActionPermissionExample();
        example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS);
        example.setOrderByClause("order_index ASC");
        List<ActionPermission> list = actionPermissionMapper.selectByExample(example);
        if(CollectionsUtil.isNotEmpty(list)){
            list = ConvertTree.getTree(list,"id");
        }
        return list;
    }

    @Override
    public boolean addPermission(Role role) throws Exception {
        role.setId(CommonUtil.generateRandomNum("r_"));
        role.setOrderIndex(StringUtils.isBlank(role.getRoleType())?0:Integer.parseInt(role.getRoleType()));
        int count = roleMapper.insertSelective(role);
        return count > 0;
    }

    @Override
    public boolean deleteRole(String id) throws Exception {
        Role role = new Role();
        role.setId(id);
        role.setStatus(Constants.DEL_STATUS);
        RoleExample example = new RoleExample();
        example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS).andIdEqualTo(id);
        int count = roleMapper.updateByExampleSelective(role,example);
        return count > 0;
    }

    @Override
    public boolean updatePermission(Role role) throws Exception {
        String id = role.getId();
        int count = 0;
        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(id).andStatusEqualTo(Constants.NORMAL_STATUS);
        List<Role> roles = roleMapper.selectByExample(example);
        if(roles.size() == 1){
            count = roleMapper.updateByExampleSelective(role,example);
        }
        return count > 0;
    }
}
