<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 11/9/2024
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show customers</title>
    <c:set var="url" value="${pageContext.request.contextPath}"/>
    <script>

        function doDelete(customerID) {
            var result = confirm("Do you really want to delete this customer?")
            if (result) {
                window.location.href = "${url}/customerdeleteservlet?customerID=" + customerID;
            }
            else {
                alert("Hanh dong da bi huy bo")
            }


        }
        function doAdd() {

            window.location.href = "${url}/customerinsertservlet";

        }


    </script>

</head>
<body>

<%--hien thi loi neu co--%>
<h1>${requestScope.err}</h1>


<%--hien thi danh sach customer--%>
<h1>${requestScope.size}</h1>

<button onclick="doAdd()">Add customer</button>
<table border="1">
    <thead>
    <tr style="color: mediumvioletred">
        <th>Customer ID</th>
        <th>Company Name</th>
        <th>Contact Name</th>
        <th>Contact Title</th>
        <th>Address</th>
        <th>City</th>
        <th>Region</th>
        <th>Postal Code</th>
        <th>Country</th>
        <th>Phone</th>
        <th>Fax</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="customer" items="${requestScope.customers}">
        <tr>
            <td>${customer.customerID}</td>
            <td>${customer.companyName}</td>
            <td>${customer.contactName}</td>
            <td>${customer.contactTitle}</td>
            <td>${customer.address}</td>
            <td>${customer.city}</td>
            <td>${customer.region}</td>
            <td>${customer.postalCode}</td>
            <td>${customer.country}</td>
            <td>${customer.phone}</td>
            <td>${customer.fax}</td>

            <td><a href="${pageContext.request.contextPath}/customerupdateservlet?customerID=${customer.customerID}">Update</a></td>
<%--            <td><a href="${pageContext.request.contextPath}/customerdeleteservlet?customerID=${customer.customerID}">Delete</a></td>--%>
            <td><button onclick="doDelete('${customer.customerID}')">Delete</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>





lay du lieu customers


</body>
</html>
