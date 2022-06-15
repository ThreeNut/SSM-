<%--
  Created by IntelliJ IDEA.
  User: ZhenZhu
  Date: 2019/11/22
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这里是登录页面</title>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>登录页面</p>
${msg}
<form action="${pageContext.request.contextPath}/index/login" method="POST">
    用户名: <input type="text" name="name"><br/>
    ID: <input type="password" name="id"><br/>
    <input type="submit" value="登录">
</form>
<a href="/account/findAll">直接访问show页面</a>
</body>
</html>
