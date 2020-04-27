<%--
  Created by IntelliJ IDEA.
  User: wendy_wan
  Date: 2020/4/27
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>执行成功</h3>
    ${requestScope.user.username}
    ${user.password}
    ${user.age}
</body>
</html>
