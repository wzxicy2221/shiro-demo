package com.zexinwang.realm;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zexinwang.entity.User;
import com.zexinwang.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/1.
 * @Description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取身份信息重写
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        User user = (User)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setRoles(userService.listRoles(user));
        authorizationInfo.setStringPermissions(userService.listPermissions(user));

        return authorizationInfo;
    }

    /**
     * 登录校验
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = new User();
        user.setUsername(usernamePasswordToken.getUsername());
        user.setPassword(String.valueOf(usernamePasswordToken.getPassword()));
        if (userService.getUser(user) == null) {
            throw new AuthenticationException("账号或密码错误");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        AuthorizationInfo authorizationInfo = getAuthorizationInfo(principals);
        if (authorizationInfo.getStringPermissions().contains(permission)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
