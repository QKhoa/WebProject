<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 11/9/2024
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>You choose product : ${requestScope.categoryName}- ${requestScope.productName}-${requestScope.minPrice}-${requestScope.maxPrice}</h1>

<form action="${pageContext.request.contextPath}/productviewservlet" method="post">



<%--    <c:set var="category" value="${requestScope.categories}"/>--%>
    <label for="categoryName">Product Category: </label>
    <select name="categoryName" id="categoryName">
        <option value="all" ${categoryName == 'all' ? 'selected' : ''}>All</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryName}" ${category.categoryName == categoryName ? 'selected' : ''}>${category.categoryName}</option>
        </c:forEach>
    </select>
    <br>

    <label for="productName">Product Name:</label>
    <input type="text" name="productName" id="productName" value="${requestScope.productName}" >



    <br>
    <%--Gia --%>
    <label for="minPrice">From:</label>
    <input type="number" name="minPrice" id="minPrice" value="${requestScope.minPrice}">
    <label for="maxPrice">to</label>
    <input type="number" name="maxPrice" id="maxPrice" value="${requestScope.maxPrice}">

    <br>
    <%--so luong--%>
    <label for="quantityPerUnit">quantityPerUnit:</label>
    <input type=number id="quantityPerUnit" name="quantityPerUnit">

    <br>
    <button type="submit">Filter</button>
    <%--    private Integer productId;--%>
    <%--    private String productName;--%>
    <%--    private Supplier supplier;--%>
    <%--    private Category category;--%>
    <%--    private String quantityPerUnit;--%>
    <%--    private Float unitPrice;--%>
    <%--    private Integer unitsInStock;--%>
    <%--    private Integer unitsOnOrder;--%>
    <%--    private Integer reorderLevel;--%>
    <%--    private Boolean discontinued ;--%>

</form>

<%--HIen thi products--%>

<c:set var="products" value="${requestScope.products}"/>
<c:if test="${not empty products}">
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity Per Unit</th>
            <th>Unit Price</th>
            <th>Units In Stock</th>
            <th>Units On Order</th>
            <th>Reorder Level</th>
            <th>Discontinued</th>
            <th>Category ID</th>
            <th>Category Name</th>
            <th>Category Description</th>
            <th>Category Picture</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.quantityPerUnit}</td>
                <td>${product.unitPrice}</td>
                <td>${product.unitsInStock}</td>
                <td>${product.unitsOnOrder}</td>
                <td>${product.reorderLevel}</td>
                <td>${product.discontinued}</td>
                <td>${product.category.categoryID}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
                <td>${product.category.picture}</td>
            </tr>
        </c:forEach>
    </table>


</c:if>


</body>
</html>
