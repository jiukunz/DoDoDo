<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Shopping Car</title>
    <link rel="stylesheet" href="/assets/css/libs/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/home.css"/>
</head>
<body>
<header class="clearfix">
    <div class="logo-box pull-left">
        <i class="logo"></i>
        <h1>Globe Images</h1>
    </div>

    <ul class="nav nav-pills pull-right">
        <li>
            <a href="#">
                <i class="user-img"></i>
                <span>Home</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="user-img"></i>
                <span>My Picture</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="user-img"></i>
                <span>Upload</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="user-img"></i>
                <span>Shopping car</span>
            </a>
        </li>
        <li class="split"></li>
        <li class="login-user">
            <a class="open" href="#">
                <i class="user-img"></i>
                <span>User</span>
            </a>
            <div class="user-profile">
                <a class="btn" href="#">Edit Profile</a>
                <a class="btn" href="#" id="logout">Logout</a>
            </div>
        </li>
    </ul>
</header>
<div class="container">
    <div class="shopping_car">
        <h2>Shopping Car</h2>
        <p>${error}</p>
        <c:forEach var="picList" items="${picList}">
            <input type="radio">
            <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="" style="width: 150px"/>
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
