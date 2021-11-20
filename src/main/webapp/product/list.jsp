<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/18/2021
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>PRODUCT MANAGER</h1>
<h2><a href="/products?action=create">CREATE NEW PRODUCT</a></h2>
<table border="1" cellpadding="5">
    <tr>
        <th>NAME</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
        <th>COLOR</th>
        <th>DESCRIPTION</th>
        <th>CATEGORY</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${productList}" var="p">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.color}</td>
            <td>${p.description}</td>
            <td>${p.getCategory().name}</td>
            <td><a href="/products?action=edit&id=${p.id}">EDIT</a></td>
            <td><a href="/products?action=delete&id=${p.id}">DELETE</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
