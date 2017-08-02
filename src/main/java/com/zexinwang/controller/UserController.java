package com.zexinwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/2.
 * @Description
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("homepage")
    public String homepage() {
        return "userhomepage";
    }

    @RequestMapping("add")
    public String add() {
        return "useradd";
    }

    @RequestMapping("update")
    public String update() {
        return "userupdate";
    }

    @RequestMapping("delete")
    public String delete() {
        return "userdelete";
    }


}
