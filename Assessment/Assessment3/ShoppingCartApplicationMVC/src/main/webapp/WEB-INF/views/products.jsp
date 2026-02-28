<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Catalog</title>
</head>
<body>
<h2>Product Catalog</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.name}</td>
    <td>${p.price}</td>
    <td>
        <input type="number" name="quantity" value="1" min="1" form="form_${p.id}"/>
    </td>
    <td>
        <form action="addToCart" method="post" id="form_${p.id}" style="margin: 0;">
            <input type="hidden" name="id" value="${p.id}"/>
            <input type="submit" value="Add to Cart"/>
        </form>
    </td>
</tr>
</c:forEach>
</table>

<br>
<a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>