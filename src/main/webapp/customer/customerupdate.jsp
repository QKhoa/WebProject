<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Information</title>
</head>
<body>
<h1 style="color:red">${requestScope.err}</h1>


<h1 style="color:blue">Cập nhật thông tin khách hàng</h1>
<hr>


<form action="${pageContext.request.contextPath}/customerupdateservlet" method="post">


    <label for="customerID"><c:out value="customerID"/></label>
    <input type="text" name="customerID" id="customerID" value="${requestScope.customer.customerID}" readonly>
    <br>
    <c:forEach var="attribute"
               items="${['companyName', 'contactName', 'contactTitle', 'address', 'city', 'region', 'postalCode', 'country', 'phone', 'fax']}">
        <label for="${attribute}"><c:out value="${attribute}"/></label>
        <input type="text" name="${attribute}" id="${attribute}" value="${requestScope.customer[attribute]}">

        <br>


    </c:forEach>
    <button type="submit">Submit</button>

</form>
</body>
</html>
