package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Function;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.dao.ShoppingCarDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCar;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingCarDao shoppingCarDao;
    @Autowired
    PictureDao pictureDao;

    @Override
    public ArrayList<Picture> getPicListByUserId(String userId) {
        List<ShoppingCar> shoppingCar = shoppingCarDao.getShoppingCarByUserId(userId).get();

        ArrayList<Picture> pictures = newArrayList(transform(shoppingCar, new Function<ShoppingCar, Picture>() {
            @Override
            public Picture apply(ShoppingCar shoppingCar) {
                return pictureDao.getPicById(shoppingCar.getPicId()).get();
            }
        }));

        return pictures;
    }
}
