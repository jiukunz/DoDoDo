<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/registration.css"/>
</head>
<body>
<div class="register-container centered">
    <h2>Sign up with Email</h2>
    <div class="register-group">
        <form class="register-form col-lg-4 col-lg-offset-4" method="post" action="/register" commandName="userForm">
            <input class="form-control first-name" type="text" placeholder="First name" name="firstName" required/>
            <label class=""></label>
            <input class="form-control" type="text" placeholder="Last name" name="lastName" required/>
            <input class="form-control" type="email" placeholder="Email Address" name="email" required/>
            <input class="form-control" type="password" placeholder="Password" name="password" required/>
            <input class="form-control" type="password" placeholder="Confirm Password" name="confirmPassword" required/>
            <button class="btn btn-primary form-control" type="submit">Sign Up</button>
        </form>
    </div>
</div>
</body>
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery.validate.min.js"></script>
<script>

    $(document).ready(function(){
        var validator =  $('.register-form').validate();
    });
</script>
</html>
