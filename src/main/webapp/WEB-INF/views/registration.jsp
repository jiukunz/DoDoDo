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
            <p class="error">${error}</p>
            <input class="form-control first-name" type="text" placeholder="First name" name="firstName" required value="${userForm.firstName}"/>
            <span id="firstName-error" class="error"></span>
            <input class="form-control" type="text" placeholder="Last name" name="lastName" required value="${userForm.lastName}"/>
            <span id="lastName-error" class="error"></span>
            <input class="form-control" type="email" placeholder="Email Address" name="email" required value="${userForm.email}"/>
            <span id="email-error" class="error"></span>
            <input class="form-control password" type="password" placeholder="Password" name="password" required/>
            <span id="password-error" class="error"></span>
            <input class="form-control" type="password" placeholder="Confirm Password" name="confirmPassword" required/>
            <span id="confirmPassword-error" class="error"></span>
            <button class="btn btn-primary form-control" type="submit">Sign Up</button>
        </form>
    </div>
</div>
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
</body>
</html>
