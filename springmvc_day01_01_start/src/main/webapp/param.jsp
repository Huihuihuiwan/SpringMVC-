<%--
  Created by IntelliJ IDEA.
  User: 54299
  Date: 2020/1/20
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--请求参数绑定--%>
<a href="param/testParam?username=hehe&password=123">请求参数绑定</a>
<%--    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>
<%--
在Accoutn中有一个引用类型的User，所以在提交表单的时候，引用类型要使用user.uname
post请求，在表单中填写中文，在控制台会出现乱码
--%>
<%--
把数据封装Account类中
user.uname对应private User user;中的user
--%>
<%--<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户姓名：<input type="text" name="user.uname"/><br/>
    用户年龄：<input type="text" name="user.age"/><br/>
    <input type="submit" value="提交"/>
</form>--%>

<%--
把数据封装Account类中，类中存在list和map

<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>

    用户姓名：<input type="text" name="list[0].uname"/><br/>
    用户年龄：<input type="text" name="list[0].age"/><br/>

    用户姓名：<input type="text" name="map['one'].uname"/><br/>
    用户年龄：<input type="text" name="map['one'].age"/><br/>
    <input type="submit" value="提交"/>
</form>
--%>

<%--
自定义类型转换器
<form action="param/saveUser" method="post">
    用户姓名：<input type="text" name="uname"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>
--%>
<a href="param/testServlet">Servlet原生的API</a>
</body>
</html>
