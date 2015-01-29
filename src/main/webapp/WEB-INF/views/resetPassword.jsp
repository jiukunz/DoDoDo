<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
    <link rel="stylesheet" href="/assets/css/libs/bootstrap.min.css"/>
</head>
<body>
<form class="reset-password-form col-lg-4 col-lg-offset-4" method="post">
    <h2>Reset Password</h2>
    <p class="error">${error}</p>
    <div class="form-group">
        <input class="form-control password" type="password" placeholder="Password" name="password" required/>
    </div>
    <div class="form-group">
        <input class="form-control" type="password" placeholder="Confirm Password" name="confirmPassword" required/>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button>
</form>
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery.validate.min.js"></script>
<script>
    $(function(){
        $('form').validate({
            rules:{
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
