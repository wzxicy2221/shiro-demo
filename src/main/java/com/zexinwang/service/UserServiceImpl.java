package com.zexinwang.service;

import com.zexinwang.dao.UserMapper;
import com.zexinwang.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

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
        roleSet.add("user");
        roleSet.add("admin");
        return roleSet;
    }

    @Override
    public Set<String> listPermissions(User user) {
        Set<String> permSet = new HashSet<>();
        permSet.add("/user/add.htm");
        permSet.add("/user/delete.htm");
        permSet.add("/admin/add.htm");
        permSet.add("/admin/update.htm");
        return permSet;
    }
}
