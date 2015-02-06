<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

  <div class="anchor">
    <ul>
      <li><a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
        <img class="smallImage" alt="aebc5914-cc1d-43ec-a031-51bf3721b517"  src="/assets/img/smalltw1.jpg"/></a>
      </li>
      <li>
        <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
          <img class="smallImage" alt="aebc5914-cc1d-43ec-a031-51bf3721b517" src="/assets/img/smalltw2.jpg"/>
        </a>
      </li>
    </ul>

  </div>


<h1>${picError}</h1>
<h2>info:${picInfo.caption}</h2>

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
