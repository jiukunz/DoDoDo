<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="uploaded-picture">
    <h3>Uploaded Pictures</h3>
    <p>${uploadedError}</p>
    <ul>
        <c:forEach var="picList" items="${uploadedPicList}">
            <li class="picInfo">
                <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="${picList.id}" style="width: 150px"/>
                <p>Caption: <c:out value="${picList.caption}"/></p>
                <p>Location: <c:out value="${picList.location}"/></p>
                <p>$<c:out value="${picList.price}"/></p>
            </li>
        </c:forEach>
    </ul>
</section>

<section class="purchased-picture">
    <h3>Purchased Pictures</h3>
    <p>${purchasedError}</p>
    <ul>
        <c:forEach var="picList" items="${purchasedPicList}">
            <li class="picInfo">
                <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="${picList.id}" style="width: 150px"/>
                <p>Caption: <c:out value="${picList.caption}"/></p>
                <p>Location: <c:out value="${picList.location}"/></p>
                <p>$<c:out value="${picList.price}"/></p>
            </li>
        </c:forEach>
    </ul>
</section>



