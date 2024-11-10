<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 11/10/2024
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<c:set value="${pageContext.request.contextPath}" var="url"/>
<h1 style="color: red">${requestScope.err}</h1>

<form method="post" action= "${url}/loginservlet">
    <label for="username">Username</label>
    <input type="text" id="username" name=username value="">
    <br>

    <label for="password">Password</label>
    <input type="password" id="password" name=password value="">

    <br>
    <button type="submit">Login</button>

</form>


</body>
</html>
