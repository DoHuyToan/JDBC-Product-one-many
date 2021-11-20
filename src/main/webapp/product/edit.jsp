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
<h2><a href="/products">RETURN PRODUCT MANAGER</a></h2>
<h1>EDIT BOOK</h1>
<form method="post">
    <table>
        <tr>
            <td>NAME</td>
            <td> <input type="text" name="name" value="${p.name}"> </td>
        </tr>
        <tr>
            <td>PRICE</td>
            <td> <input type="text" name="price" value="${p.price}"> </td>
        </tr>
        <tr>
            <td>QUANTITY</td>
            <td> <input type="text" name="quantity" value="${p.quantity}"> </td>
        </tr>
        <tr>
            <td>COLOR</td>
            <td> <input type="text" name="color" value="${p.color}"> </td>
        </tr>
        <tr>
            <td>DESCRIPTION</td>
            <td> <input type="text" name="description" value="${p.description}"> </td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="category">
                    <c:forEach items="${categoryList}" var="cas">
                        <option value="${cas.id}">${cas.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td> <input type="submit" value="Edit"> </td>
        </tr>
    </table>
</form>

</body>
</html>
