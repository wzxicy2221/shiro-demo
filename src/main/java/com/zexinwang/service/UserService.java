package com.zexinwang.service;

import com.zexinwang.entity.User;

import java.util.List;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
public interface UserService {

    List<User> listUser() throws Exception;

}
