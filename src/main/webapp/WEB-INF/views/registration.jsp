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
            <label id="firstName-error" class="error" for="firstName"></label>
            <input class="form-control" type="text" placeholder="Last name" name="lastName" required/>
            <label id="lastName-error" class="error" for="lastName"></label>
            <input class="form-control" type="email" placeholder="Email Address" name="email" required/>
            <label id="email-error" class="error" for="email"></label>
            <input class="form-control password" type="password" placeholder="Password" name="password" required/>
            <label id="password-error" class="error" for="password"></label>
            <input class="form-control" type="password" placeholder="Confirm Password" name="confirmPassword" required/>
            <label id="confirmPassword-error" class="error" for="ConfirmPassword"></label>
            <button class="btn btn-primary form-control" type="submit">Sign Up</button>
        </form>
    </div>
</div>
</body>
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery.validate.min.js"></script>
<script>

    $(document).ready(function(){
        $('.register-form').validate({
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
</html>
