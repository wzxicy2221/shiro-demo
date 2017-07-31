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
        int a = 1;
        Example example = new Example(User.class);
        User user = new User();
        user.setLocked(true);
        a = a + 1;
        userMapper.updateByExampleSelective(user, example);
//        if (a == 2) {
//            throw new RuntimeException("aaa");
//        }
        return userMapper.selectByExample(example);
    }
}
