package com.zexinwang.service;

import com.zexinwang.dao.PermissionMapper;
import com.zexinwang.dao.RoleMapper;
import com.zexinwang.dao.UserMapper;
import com.zexinwang.entity.Permission;
import com.zexinwang.entity.Role;
import com.zexinwang.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> listUser() throws Exception {
        Example example = new Example(User.class);
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUser(User user) {
        if(null == user) {
            return null;
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", user.getUsername())
                .andEqualTo("password", user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

    @Override
    public Set<String> listRoles(User user) {
        Set<String> roleSet = new HashSet<>();
        User curUser = getUser(user);
        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("userId", curUser.getId());
        List<Role> roles = roleMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(roles)) {
            roleSet = roles.stream().map(Role::getRole).collect(Collectors.toSet());
        }
        return roleSet;
    }

    @Override
    public Set<String> listPermissions(User user) {
        Set<String> permSet = new HashSet<>();
        User curUser = getUser(user);
        Example example = new Example(Permission.class);
        example.createCriteria().andEqualTo("userId", curUser.getId());
        List<Permission> roles = permissionMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(roles)) {
            permSet = roles.stream().map(Permission::getPermission).collect(Collectors.toSet());
        }
        return permSet;
    }
}
