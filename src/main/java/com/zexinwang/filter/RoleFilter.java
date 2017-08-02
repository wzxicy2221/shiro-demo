package com.zexinwang.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/2.
 * @Description
 */
public class RoleFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request,
            ServletResponse response, Object mappedValue)
            throws Exception {
        Subject subject = SecurityUtils.getSubject();
        // admin或user角色能通过角色校验
        if (subject.hasRole("admin") ||  subject.hasRole("user")) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
            ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, "/index/noauth.htm");
        return false;
    }
}
