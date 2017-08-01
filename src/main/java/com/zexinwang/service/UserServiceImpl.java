package com.zexinwang.service;

import com.zexinwang.dao.UserMapper;
import com.zexinwang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
}
