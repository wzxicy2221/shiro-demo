package com.zexinwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/2.
 * @Description
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("homepage")
    public String homepage() {
        return "adminhomepage";
    }

    @RequestMapping("add")
    public String add() {
        return "adminadd";
    }

    @RequestMapping("delete")
    public String delete() {
        return "admindelete";
    }

}
