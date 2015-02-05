package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.dao.ShoppingCarDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCar;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCarService;
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

public class ShoppingCarServiceImplTest {

    @InjectMocks
    ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();
    @Mock
    ShoppingCarDao shoppingCarDao;
    @Mock
    PictureDao pictureDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldGetPicListByUserId() {
        String userId = "1";
        List<ShoppingCar> shoppingCarList = new ArrayList<>();
        ShoppingCar car = new ShoppingCar();
        shoppingCarList.add(car);
        when(shoppingCarDao.getShoppingCarByUserId(anyString())).thenReturn(Optional.of(shoppingCarList));
        Picture picture = new Picture();
        picture.setId("123456");
        when(pictureDao.getPicById(anyString())).thenReturn(Optional.of(picture));
        ArrayList<Picture> picListByUserId = shoppingCarService.getPicListByUserId(userId);
        assertThat(picListByUserId.get(0).getId(), is(picture.getId()));
    }

    @Test
    public void shouldReturnEmptyListWhenShoppingCarIsEmpty() {
        String userId = "1";
        when(shoppingCarDao.getShoppingCarByUserId(anyString())).thenReturn(Optional.<List<ShoppingCar>>absent());
        when(pictureDao.getPicById(anyString())).thenReturn(Optional.<Picture>absent());
        ArrayList<Picture> picListByUserId = shoppingCarService.getPicListByUserId(userId);
        assertThat(picListByUserId.size(), is(0));
    }
}