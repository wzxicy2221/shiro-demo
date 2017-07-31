package com.zexinwang.controller;

import com.zexinwang.entity.User;
import com.zexinwang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello.htm")
    public String hello() {
        try {
            List<User> userList = userService.listUser();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "hello";
    }

}
