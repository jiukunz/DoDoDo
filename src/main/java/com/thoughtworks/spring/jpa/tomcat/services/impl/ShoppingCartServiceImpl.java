package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.commons.AddShoppingCartStatus;
import com.thoughtworks.spring.jpa.tomcat.commons.json.ShoppingCartResponse;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.dao.ShoppingCartDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDao shoppingCartDao;
    @Autowired
    PictureDao pictureDao;

    @Override
    public ArrayList<Picture> getPicListByUserId(String userId) {
        List<ShoppingCart> shoppingCart = new ArrayList<>();
        Optional<List<ShoppingCart>> shoppingCartByUserId = shoppingCartDao.getShoppingCarByUserId(userId);
        if (shoppingCartByUserId.isPresent()) {
            shoppingCart = shoppingCartByUserId.get();
        }

        ArrayList<Picture> pictures = newArrayList(transform(shoppingCart, new Function<ShoppingCart, Picture>() {
            @Override
            public Picture apply(ShoppingCart shoppingCar) {
                return pictureDao.getPicById(shoppingCar.getPicId()).get();
            }
        }));

        return pictures;
    }

    @Override
    public ShoppingCartResponse addShoppingCar(ShoppingCart shoppingCart) {
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();

        if (Optional.absent().equals(pictureDao.getPicById(shoppingCart.getPicId()))) {
            shoppingCartResponse.setStatus(AddShoppingCartStatus.PICTURE_NOT_EXIT);
        }

        shoppingCartDao.persist(shoppingCart);

        return shoppingCartResponse;

    }
}
