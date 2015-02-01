<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/assets/css/profile.css" />
</head>
<body>
<div class="container">
    <form class="profile-form" method="post">
        <label>Hi, ${user.email}</label>
        <label>First Name</label>
        <input type="text" value=${user.firstName} name="firstName" />
        <label>Last Name</label>
        <input type="text" value=${user.lastName} name="lastName" />

        <input type="submit" name="save" value="Save" class="profile-save"/>
        <input type="button" name="cancle" value="Cancle" onclick="window.location.href='/home'" />
    </form>
</div>

</body>
</html>
