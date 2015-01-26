<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="register-container">
    <h1>Create Your Account</h1>
    <div class="register-group">
        <form class="register-form" method="post" action="/register" commandName="userForm">
            <p>Your first name:</p>
            <input class="form-control" type="text" placeholder="First name" name="firstName" required="required"/>
            <p>Your last named:</p>
            <input class="form-control" type="text" placeholder="Last name" name="lastName" required="required"/>
            <p>Your email address:</p>
            <input class="form-control" type="email" placeholder="Email address" name="email" required="required"/>
            <p>Create your password:</p>
            <input class="form-control" type="password" placeholder="password" name="password" required="required"/>
            <p>Confirm your password:</p>
            <input class="form-control" type="password" placeholder="password" name="confirmPassword" required="required"/>
            <button class="btn btn-primary" type="submit">Create</button>
        </form>
    </div>
</div>
</body>
</html>
