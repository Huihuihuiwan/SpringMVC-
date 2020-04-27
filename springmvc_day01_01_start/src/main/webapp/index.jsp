<%--
  Created by IntelliJ IDEA.
  User: wendy_wan
  Date: 2020/1/19
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>入门程序</h3>
<%--    testRequestMapping<a href="hello">入门程序</a>--%>

    <%--<a href="hello">入门程序</a>--%>
    <%--
    /user/testRequestMapping:找不到资源文件，不能加上最前面的反斜杠/
    --%>
    <a href="user/testRequestMapping?username=hehe">RequestMapping注解</a>
</body>
</html>
