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
<h1> <a href="/products">RETURN PRODCUT MANAGER</a></h1>
<form method="post">
    <table>
        <tr>
            <th>NAME</th>
            <td> <input type="text" name="name"> </td>
        </tr>
        <tr>
            <th>PRICE</th>
            <td> <input type="text" name="price"> </td>
        </tr>
        <tr>
            <th>QUANTITY</th>
            <td> <input type="text" name="quantity"> </td>
        </tr>
        <tr>
            <th>COLOR</th>
            <td> <input type="text" name="color"> </td>
        </tr>
        <tr>
            <th>DESCRIPTION</th>
            <td> <input type="text" name="description"> </td>
        </tr>
        <tr>
            <th>CATEGORY</th>
            <td>
                <select name="category">
                    <c:forEach items="${categoryList}" var="p">
                        <option value="${p.id}">${p.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td> <input type="submit" value="Create"> </td>
        </tr>












    </table>
</form>
</body>
</html>
