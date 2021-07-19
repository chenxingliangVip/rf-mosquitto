package com.cn.manage.service;


import com.cn.manage.api.IRoleService;
import com.cn.manage.dao.RoleMapper;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Role;
import com.cn.manage.domain.RoleExample;
import com.cn.manage.util.Constants;
import com.cn.manage.utils.CollectionsUtil;
import com.cn.manage.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoleList() throws Exception {
        RoleExample example = new RoleExample();
        example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS);
        example.setOrderByClause("order_index ASC");
        List<Role> list = roleMapper.selectByExample(example);
        return list;
    }

    @Override
    public Boolean deleteRole(QueryForm queryForm) throws Exception {
        int count = 0;
        List<String> ids = queryForm.getIds();
        if(CollectionsUtil.isNotEmpty(ids)){
            Role role = new Role();
            role.setStatus(Constants.DEL_STATUS);
            RoleExample example = new RoleExample();
            example.createCriteria().andIdIn(ids);
            count = roleMapper.updateByExampleSelective(role,example);
        }
        return count > 0;
    }

    private int countRoleByName(String name,String id){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS).andRoleNameEqualTo(name);
        if(StringUtils.isNotBlank(id)){
            criteria.andIdNotEqualTo(id);
        }
        int count = roleMapper.countByExample(example);
        return count;
    }

    @Override
    public Boolean addRole(Role role) throws Exception {
        if(this.countRoleByName(role.getRoleName(),"") > 0){
            return false;
        }
        role.setId(CommonUtil.generateRandomNum("role-"));
        int count  = roleMapper.insertSelective(role);
        return count > 0;
    }

    @Override
    public Boolean updateRole(Role role) throws Exception {
        int count = 0;
        if(StringUtils.isNotBlank(role.getId())){
            if(this.countRoleByName(role.getRoleName(),role.getId()) > 0){
                return false;
            }
            RoleExample example = new RoleExample();
            example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS).andIdEqualTo(role.getId());
            count = roleMapper.updateByExampleSelective(role,example);
        }
        return count > 0;
    }
}
