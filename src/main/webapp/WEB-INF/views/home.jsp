<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<section class="head">
    <h3>Home</h3>
    <div class="search-box">
        <input type="text" placeholder="Search"/>
    </div>
</section>

<section class="featured-picture">
    <h4>Featured Pictures</h4>
    <a href="/featuredPictures">View More Featured Pictures</a>

    <p>${error}</p>
    <ul>
        <c:forEach var="picList" items="${picList}">
            <li class="picInfo">
                <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
                    <img class="smallImage" src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt="${picList.id}" />
                </a>
                <p>Caption: <c:out value="${picList.caption}"/></p>
                <p>$<c:out value="${picList.price}"/></p>
            </li>
        </c:forEach>
    </ul>
</section>

<section class="new-picture">
    <h4>New Pictures</h4>
    <a href="/newPictures">View More New Pictures</a>

    <p>${error}</p>
    <ul>
        <c:forEach var="newPic" items="${newPicList}">
            <li class="picInfo">
                <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
                    <img class="smallImage" src="http://7u2rkn.com1.z0.glb.clouddn.com/${newPic.id}" alt="${newPic.id}" />
                </a>
                <p>Caption: <c:out value="${newPic.caption}"/></p>
                <p>$<c:out value="${newPic.price}"/></p>
            </li>
        </c:forEach>
    </ul>
</section>

<div id="pictureContent" style="display: none">
    <img class="biggerImage" src="" />

    <div class="pictureInformation">
        Caption:<p class="pictureCaption"></p>
        Keyword:<p class="pictureKeyword"></p>
        Location:<p class="pictureLocation"></p>
        Price:<p class="picturePrice"></p>
        <button type="button">Add Cart</button>
    </div>

</div>

<button id="addToCart">add to cart</button>
<script>
    $("#addToCart").click(function(){
        $.ajax({
            type: "POST",
            url: "/shopping-cart/add",
            data:{"picture_id":111111},
            success: function(data){
                if(console){
                    console.log(data);
                }
            }
        });
    });
</script>

