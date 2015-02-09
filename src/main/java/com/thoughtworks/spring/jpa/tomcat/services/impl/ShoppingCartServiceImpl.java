package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
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

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDao shoppingCartDao;
    @Autowired
    PictureDao pictureDao;

    @Override
    public ImmutableList<Picture> getPicListByUserId(String userId) {
        List<ShoppingCart> shoppingCart = new ArrayList<>();
        Optional<List<ShoppingCart>> shoppingCartByUserId = shoppingCartDao.getShoppingCarByUserId(userId);
        ImmutableList<Picture> pictures = null;
        if (shoppingCartByUserId.equals(Optional.<List<ShoppingCart>>absent())) {
            return pictures;
        }

        shoppingCart = shoppingCartByUserId.get();

        pictures = getFilteredPictures(shoppingCart);

        return pictures;
    }

    private ImmutableList<Picture> getFilteredPictures(List<ShoppingCart> shoppingCart) {
        return FluentIterable.from(shoppingCart)
                .filter(new Predicate<ShoppingCart>() {
                    @Override
                    public boolean apply(ShoppingCart shoppingCart) {
                        if (pictureDao.getPicById(shoppingCart.getPicId()).equals(Optional.<Picture>absent())) {
                            shoppingCartDao.delete(shoppingCart);
                        }
                        return pictureDao.getPicById(shoppingCart.getPicId()).isPresent();
                    }
                })
                .transform(new Function<ShoppingCart, Picture>() {
                    @Override
                    public Picture apply(ShoppingCart shoppingCart) {
                        return pictureDao.getPicById(shoppingCart.getPicId()).get();
                    }
                })
                .toList();
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
