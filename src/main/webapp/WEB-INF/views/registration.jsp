<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="/assets/css/libs/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/login.css"/>
</head>
<body>
<main class="content">
    <header class="login-header">
        <i class="logo"></i>
        <h1>Globe Images</h1>
    </header>
    <form class="form-login" role="form" method="post" action="/register" commandName="userForm">
        <h3 class="signin-heading">Sign up with Email</h3>
        <p class="error">${error}</p>
        <div class="row form-group">
            <div class="col-md-6">
                <input class="form-control first-name" type="text" placeholder="First name" name="firstName" required value="${userForm.firstName}"/>
            </div>
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="Last name" name="lastName" required value="${userForm.lastName}"/>
            </div>
        </div>
        <div class="form-group">
            <input class="form-control" type="email" placeholder="Email Address" name="email" required value="${userForm.email}"/>
        </div>
        <div class="form-group">
            <input class="form-control password" type="password" placeholder="Password" name="password" required/>
        </div>
        <div class="form-group">
            <input class="form-control" type="password" placeholder="Confirm Password" name="confirmPassword" required/>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
    </form>
</main>
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery.validate.min.js"></script>
<script>
    $(function(){
        $('form').validate({
            rules:{
                firstName: "required",
                lastName: "required",
                email:{
                    required: true,
                    email: true
                },
                password:{
                    required: true,
                    minlength: 5
                },
                confirmPassword:{
                    required: true,
                    minlength: 5,
                    equalTo: ".password"
                }
            },
            messages:{
                firstName: "Please enter your first name.",
                lastName: "Please enter your last name.",
                email: "Please enter a valid email address",
                password: {
                    required : "Please provide a password.",
                    minlength: "Your password must be at least 5 characters long."
                },
                confirmPassword:{
                    required: "Please provide a password.",
                    minlength: "Your password must be at least 5 characters long.",
                    equalTo: "Please enter the same password as above."
                }
            }
        });
    });
</script>
</body>
</html>
