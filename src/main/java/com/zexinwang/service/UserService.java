package com.zexinwang.service;

import com.zexinwang.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
public interface UserService {

    List<User> listUser() throws Exception;

    User getUser(User user);

    Set<String> listRoles(User user);

    Set<String> listPermissions(User user);

}
