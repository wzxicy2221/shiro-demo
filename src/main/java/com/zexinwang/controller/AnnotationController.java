package com.zexinwang.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/8.
 * @Description
 */
@Controller
@RequestMapping("annotation")
public class AnnotationController {

    @RequestMapping("teacher")
    @RequiresRoles("teacher")
    public String teacher() {
        return "teacherhomepage";
    }

}
