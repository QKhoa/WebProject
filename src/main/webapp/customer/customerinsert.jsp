<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 11/9/2024
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 style="color:red;">Dien thong tin vao form</h1>
<form action="${pageContext.request.contextPath}/customerinsertservlet" method="post">
    <c:forEach var="attribute"
               items="${['customerID', 'companyName', 'contactName', 'contactTitle', 'address', 'city', 'region', 'postalCode', 'country', 'phone', 'fax']}">
        <label for="${attribute}">${attribute}</label>
        <input type="text" name="${attribute}" id="${attribute}" value="" required>

        <br>


    </c:forEach>

    <button type="submit">Send</button>
</form>

</body>
</html>
