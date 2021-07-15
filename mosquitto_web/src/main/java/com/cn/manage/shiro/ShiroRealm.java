package com.cn.manage.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroRealm  extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        List<String> roles = permissionService.findRole(username);
//        authorizationInfo.setRoles(new HashSet<String>(roles));
//        List<String> permission = permissionService.queryUserPermission(username);
//        authorizationInfo.setStringPermissions(new HashSet<String>(permission));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        char[] bytePwd = (char[]) authenticationToken.getCredentials();
        String password = String.valueOf(bytePwd);
//        Login param = new Login();
//        param.setUserAccount(username);
//        param.setPassword(password);
//        Login login = null;
//        try {
//            login = loginService.queryLogin(param);
//        } catch (Exception e) {
//        }
//        if (login == null) {
//            // 用户名不存在抛出异常
//            throw new UnknownAccountException();
//        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("",
                "",getName());
        return authenticationInfo;
    }
}
