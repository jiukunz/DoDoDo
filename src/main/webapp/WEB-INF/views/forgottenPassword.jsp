<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgotten Password</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
</head>
<body>
<form class="forgotten-password-form col-lg-4 col-lg-offset-4" method="post">
    <h2>Forgotten Password</h2>
    <p>Please input your email address to reset password.</p>
    <input class="form-control" name="email" type="text" placeholder="Email Address"/>
    <div class="">${error}</div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button>
</form>
</body>
</html>
