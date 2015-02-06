package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.commons.json.ShoppingCartResponse;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;

import java.util.ArrayList;

public interface ShoppingCartService {
    ArrayList<Picture> getPicListByUserId(String userId);

    ShoppingCartResponse addShoppingCar(ShoppingCart shoppingCart);
}
