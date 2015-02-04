<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <%--<link rel="stylesheet" href="/assets/css/profile.css" />--%>
    <link rel="stylesheet" href="/assets/css/libs/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/login.css"/>
</head>
<body>
<main class="content">
    <header class="login-header">
        <i class="logo"></i>
        <h1>Hi, ${user.email}</h1>
    </header>
    <form class="form-login" method="post" role="form">
        <h3 class="signin-heading">Please edit your profile.</h3>
        <label>First Name</label>
        <input class="form-group form-control" name="firstName" type="text" value=${user.firstName} />
        <label>Last Name</label>
        <input class="form-group form-control" name="lastName" type="text" value=${user.lastName} />

            <button type="submit" class=" btn-sm btn-primary form-control">Save</button>
            <button type="button" class=" btn-sm btn-primary form-control" onclick="window.location.href='/home'" >Cancle</button>
        </div>
    </form>
</main>

<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/jquery.validate.min.js"></script>
<script>
    $(function(){
      $('form').validate({
         rules:{
             firstName: "required",
             lastName: "required"
         },
          messages: {
              firstName: "Please enter your first name",
              lastName: "Please enter your last name"
          }
      });
    });
</script>

</body>
</html>
