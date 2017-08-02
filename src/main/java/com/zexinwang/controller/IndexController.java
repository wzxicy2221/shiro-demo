package com.zexinwang.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/1.
 * @Description
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("noauth")
    public String noauth() {
        return "noauth";
    }

    @RequestMapping("submitLogin")
    public String submitLogin(UsernamePasswordToken usernamePasswordToken, HttpServletResponse response)
            throws IOException {
        usernamePasswordToken.setRememberMe(true);
        SecurityUtils.getSubject().login(usernamePasswordToken);
        response.sendRedirect("/other/homepage.htm");
        return "login";
    }

}
