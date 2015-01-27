<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/main.css"/>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post">
        <h1 class="signin-heading">Login to Globe Images</h1>
        <input class="form-control" name="username" type="text" placeholder="Username"/>
        <input class="form-control" name="password" type="password" placeholder="Password"/>
        <div class="">${error}</div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        <a class="" href="">Forgot Password</a>
        <a class="" href="register">Sign up</a>
    </form>
</div>
</body>
</html>
