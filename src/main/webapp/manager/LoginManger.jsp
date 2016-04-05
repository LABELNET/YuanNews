<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-4-5
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员登陆</title>
</head>
<body>
    <form method="post" action="/managerLogin.action">
        <input id="unum" name="unum" type="number"><br>
        <input id="pass" name="pass" type="password"><br>
        <input type="submit" title="注册">
    </form>
</body>
</html>
