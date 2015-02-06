<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<main class="content">
    <form class="form-login" method="post" role="form">
        <h3 class="signin-heading">Hi, ${user.email}.</h3>
        <label>First Name</label>
        <input class="form-group form-control" name="firstName" type="text" value=${user.firstName} />
        <label>Last Name</label>
        <input class="form-group form-control" name="lastName" type="text" value=${user.lastName} />

            <button type="submit" class=" btn-sm btn-primary form-control">Save</button>
            <button type="button" class=" btn-sm btn-primary form-control" onclick="window.location.href='/home'" >Cancle</button>
        </div>
    </form>
</main>
