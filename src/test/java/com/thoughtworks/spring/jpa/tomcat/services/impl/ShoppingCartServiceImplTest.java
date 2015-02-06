package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.dao.ShoppingCartDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCartService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ShoppingCartServiceImplTest {

    @InjectMocks
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    @Mock
    ShoppingCartDao shoppingCartDao;
    @Mock
    PictureDao pictureDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldGetPicListByUserId() {
        String userId = "1";
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        ShoppingCart car = new ShoppingCart();
        shoppingCartList.add(car);
        when(shoppingCartDao.getShoppingCarByUserId(anyString())).thenReturn(Optional.of(shoppingCartList));
        Picture picture = new Picture();
        picture.setId("123456");
        when(pictureDao.getPicById(anyString())).thenReturn(Optional.of(picture));
        ArrayList<Picture> picListByUserId = shoppingCartService.getPicListByUserId(userId);
        assertThat(picListByUserId.get(0).getId(), is(picture.getId()));
    }

    @Test
    public void shouldReturnEmptyListWhenShoppingCarIsEmpty() {
        String userId = "1";
        when(shoppingCartDao.getShoppingCarByUserId(anyString())).thenReturn(Optional.<List<ShoppingCart>>absent());
        when(pictureDao.getPicById(anyString())).thenReturn(Optional.<Picture>absent());
        ArrayList<Picture> picListByUserId = shoppingCartService.getPicListByUserId(userId);
        assertThat(picListByUserId.size(), is(0));
    }
}