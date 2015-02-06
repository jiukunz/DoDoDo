<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <section class="category">
        <h3>Shopping Cart</h3>
    </section>
    <form action="">
        <p>${error}</p>
        <ul class="items">
            <c:forEach var="picList" items="${picList}">
            <li>
                <div class="column checker">
                    <input class="" type="checkbox"/>
                </div>
                <div class="column image-info">
                    <img class="column img" src="http://7u2rkn.com1.z0.glb.clouddn.com/${picList.id}" alt=""/>
                    <dl class="column infos clearfix">
                        <dt>Caption:</dt><dd>${picList.caption}</dd>
                        <dt>Location:</dt><dd>${picList.location}</dd>
                    </dl>
                </div>
                <div class="column price">
                    <strong>$ ${picList.price}</strong>
                </div>
            </li>
            </c:forEach>
        </ul>
        <p class="center totals">
            Subtotals (<span class="count">2</span> items): <strong class="price">$${totalPrice}</strong>
        </p>
        <div class="form-group center">
            <button class="btn btn-lg btn-primary" type="submit">Proceed to Checkout</button>
        </div>
    </form>
</main>