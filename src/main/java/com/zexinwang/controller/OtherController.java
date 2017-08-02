package com.zexinwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/2.
 * @Description
 */
@Controller
@RequestMapping("other")
public class OtherController {

    @RequestMapping("homepage")
    public String homePage() {
        return "homepage";
    }

}
