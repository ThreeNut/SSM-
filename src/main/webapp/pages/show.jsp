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
<title>Insert title here</title>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>

<h1>拦截器的简单演示案例HandlerInterceptor</h1>
<h2>当前用户登录账户:${USER_SESSION.name} ||     <a href="${pageContext.request.contextPath}/index/logout"> 退出登录 </a></h2>
<p>这是首页内容</p>
<br/>
登录才可以查询数据
<a href="/account/findAll">查询mysql</a>
<form>
    <c:forEach items="${item}" var="item">
    <table border=1>
        <tr>
            <td>名称</td>
            <td> ${item.name } </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td> ${item.age } </td>
        </tr>
       <%-- <tr>
            <td>生成日期</td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>--%>
        <tr>
            <td>email</td>
            <td>${item.email} </td>
        </tr>
        <p>........数据的简单演示.........</p>
        </c:forEach>
    </table>

</form>
</body>
</html>
