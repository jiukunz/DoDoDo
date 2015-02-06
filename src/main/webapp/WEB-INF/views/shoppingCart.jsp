<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="/assets/css/libs/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/home.css"/>
</head>
<body>
<div class="container">
    <div class="shopping_cart">
        <h2>Shopping Cart</h2>
        <p>${error}</p>
        <c:forEach var="picList" items="${picList}">
            <input type="radio">
            <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="" style="width: 150px"/>
            <p>Caption: <c:out value="${picList.caption}"/></p>
            <p>Location: <c:out value="${picList.location}"/></p>
            <h1>$<c:out value="${picList.price}"/></h1>
        </c:forEach>
        <h2>Subtotals: $${totalPrice}</h2>
        <button type="submit">Proceed to Checkout</button>
    </div>
</div>
</body>
</html>
