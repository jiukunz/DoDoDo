<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="anchor">
    <h2>My Pictures</h2>
    <p>${error}</p>
    <ul>
        <c:forEach var="picList" items="${picList}">
            <li>
                <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
                    <img src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="${picList.id}" style="width: 150px"/>
                </a>
                <p>Caption: <c:out value="${picList.caption}"/></p>
                <p>Location: <c:out value="${picList.location}"/></p>
                <p>$<c:out value="${picList.price}"/></p>
            </li>
        </c:forEach>
    </ul>

</div>

  <div id="pictureContent" style="display: none">
      <%--<img class="loading" src="/assets/img/loadingAnimation.gif" />--%>
      <%--<div class="imageContent">--%>
      <img class="biggerImage" src="/assets/img/picture1.jpg" />
      <%--</div>--%>

      <div class="pictureInformation">
          Caption:<p class="pictureCaption"></p>
          Keyword:<p class="pictureKeyword"></p>
          Location:<p class="pictureLocation"></p>
          Price:<p class="picturePrice"></p>
        <button type="button">Add Cart</button>
      </div>

  </div>
