<%--
  Created by IntelliJ IDEA.
  User: ucmed
  Date: 2017/8/2
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>homepage</title>
</head>
<body>
首页

<shiro:hasRole name="admin">
    用户[<shiro:principal/>]拥有角色admin<br/>
</shiro:hasRole>

<shiro:hasRole name="user">
    用户[<shiro:principal/>]拥有角色user<br/>
</shiro:hasRole>

<shiro:hasPermission name="/admin/add.htm">
    用户[<shiro:principal/>]拥有权限/admin/add.htm<br/>
    <a href="/admin/add.htm">/admin/add.htm</a>
</shiro:hasPermission>

<shiro:hasPermission name="/user/add.htm">
    用户[<shiro:principal/>]拥有权限/user/add.htm<br/>
    <a href="/user/add.htm">/user/add.htm</a>
</shiro:hasPermission>
</body>
</html>
