<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Summary</title>
</head>
<body>

<h2>Cart Summary</h2>

<table border="1">
<tr>
    <th>Product</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Action</th>
</tr>

<c:forEach var="item" items="${cartItems}">
<tr>
    <td>${item.product.name}</td>
    <td>${item.product.price}</td>
    <td>
        <form action="updateQuantity" method="post" style="margin: 0;">
            <input type="hidden" name="id" value="${item.product.id}"/>
            <input type="number" name="quantity" value="${item.quantity}" min="0"/>
            <input type="submit" value="Update"/>
        </form>
    </td>
    <td>${item.total}</td>
    <td>
        <form action="updateQuantity" method="post" style="margin: 0;">
            <input type="hidden" name="id" value="${item.product.id}"/>
            <input type="hidden" name="quantity" value="0"/>
            <input type="submit" value="Remove"/>
        </form>
    </td>
</tr>
</c:forEach>
</table>

<h3>Total Amount: ${total}</h3>

<a href="products">Continue Shopping</a>
<br><br>
<c:if test="${not empty cartItems}">
    <a href="checkout">Proceed to Checkout</a>
</c:if>

<br><br>
<a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>