<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h2>My Pictures</h2>

    <div class="uploadedPic">
        <h3>Uploaded Pictures</h3>
        <p>${error}</p>
        <ul>
            <c:forEach var="picList" items="${picList}">
                <li class="picInfo">
                    <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="${picList.id}" style="width: 150px"/>
                    <p>Caption: <c:out value="${picList.caption}"/></p>
                    <p>Location: <c:out value="${picList.location}"/></p>
                    <p>$<c:out value="${picList.price}"/></p>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="purchased-pictures">
        <h3>Purchased Pictures</h3>
    </div>

</div>

