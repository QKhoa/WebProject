<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<form action="inputname" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name">

    <button type="submit">Send</button>
</form>

<c:forEach var="name" items="${sessionScope.names}">
    <h3>${name}</h3>
</c:forEach>

</body>
</html>