<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Car</title>
</head>
<body>
<div class="container">
    <div class="shopping_car">
        <h2>Shopping Car</h2>
        <c:forEach var="picList" items="${picList}">
            <input type="radio">
            <p>Caption: <c:out value="${picList.caption}"/></p>
            <p>Location: <c:out value="${picList.location}"/></p>
            <h1>$<c:out value="${picList.price}"/></h1>
        </c:forEach>
        <h2>Subtotals: $${totalPrice}</h2>
        <button>Proceed to Checkout</button>
    </div>
</div>
</body>
</html>
