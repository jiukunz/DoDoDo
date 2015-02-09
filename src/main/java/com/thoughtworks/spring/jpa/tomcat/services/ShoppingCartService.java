package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.spring.jpa.tomcat.commons.json.ShoppingCartResponse;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;

public interface ShoppingCartService {
    ImmutableList<Picture> getPicListByUserId(String userId);

    ShoppingCartResponse addShoppingCar(ShoppingCart shoppingCart);

    ShoppingCartResponse deleteShoppingCart(ShoppingCart shoppingCart);
}
