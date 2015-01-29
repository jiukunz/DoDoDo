<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/login.css"/>
</head>
<body>
<main class="content">
    <header class="login-header">
        <i class="logo"></i>
        <h1>Globe Images</h1>
    </header>

    <form class="form-login" method="post" role="form">
        <h3 class="signin-heading">Login to Globe Images</h3>
        <input class="form-group form-control" name="username" type="text" placeholder="Email"/>
        <input class="form-group form-control" name="password" type="password" placeholder="Password"/>
        <div class="error message">${error}</div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        <div class="form-bottom clearfix">
            <a class="pull-left forgot" href="/forgotten/password">Forgotten Password</a>
            <a class="pull-right signup" href="/register">Sign up</a>
        </div>
    </form>
</main>
</body>
</html>
