<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="com" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <div class="container dropdown-picture">
        <form action="/upload"
              class="dropzone"
              id="my-awesome-dropzone" method="post" enctype="multipart/form-data">
        </form>
    </div>

    <div class="container uploaded-picture">
        <i>Picture Uploaded</i>
        <i>(3 uploaded, 1 in progress)</i>

    </div>
</body>