<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
</head>
<body>
<h2>Checkout Summary</h2>

<ul>
<c:forEach var="item" items="${cartItems}">
    <li>${item.product.name} - Quantity: ${item.quantity} - Subtotal: ${item.total}</li>
</c:forEach>
</ul>

<h3>Total to Pay: ${total}</h3>

<form action="processCheckout" method="post">
    <input type="submit" value="Confirm Order"/>
</form>
<br>
<a href="cart">Return to Cart</a>
</body>
</html>