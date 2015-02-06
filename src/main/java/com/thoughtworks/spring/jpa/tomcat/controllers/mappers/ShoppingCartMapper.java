package com.thoughtworks.spring.jpa.tomcat.controllers.mappers;

import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ShoppingCartMapper {
    public ShoppingCart mapper(String userId, String picId) {
        java.util.Date date = new java.util.Date();

        Long uId = Long.parseLong(userId);
        ShoppingCart shoppingCart = new ShoppingCart()
                .withUserId(uId)
                .withPicId(picId)
                .withCreateDate(new Timestamp(date.getTime()))
                .withModifyDate(new Timestamp(date.getTime()));
        return shoppingCart;
    }
}
