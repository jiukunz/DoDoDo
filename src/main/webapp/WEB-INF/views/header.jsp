<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<header class="clearfix">
    <div class="logo-box pull-left">
        <i class="logo"></i>
        <h1>Globe Images</h1>
    </div>

    <ul class="nav nav-pills pull-right">
        <li>
            <a href="/home">
                <i class="user-img"></i>
                <span>Home</span>
            </a>
        </li>
        <li>
            <a href="/picture">
                <i class="user-img"></i>
                <span>My Picture</span>
            </a>
        </li>
        <li>
            <a href="/upload">
                <i class="user-img"></i>
                <span>Upload</span>
            </a>
        </li>
        <li>
            <a href="/shopping_car">
                <i class="user-img"></i>
                <span>Shopping car</span>
            </a>
        </li>
        <li class="split"></li>
        <li class="login-user">
            <a class="open" href="/home">
                <i class="user-img"></i>
                <span>User</span>
            </a>
            <div class="user-profile">
                <a class="btn" href="/profile">Edit Profile</a>
                <a class="btn" href="/logout" id="logout">Logout</a>
            </div>
        </li>
    </ul>
</header>
