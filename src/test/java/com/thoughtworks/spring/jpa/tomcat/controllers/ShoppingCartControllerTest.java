package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCartService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ShoppingCartControllerTest {
    @InjectMocks
    ShoppingCartController shoppingCartController;
    @Mock
    ShoppingCartService shoppingCartService;
    @Mock
    MessageSource messageSource;

    HttpSession httpSession;
    Model model;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        httpSession = mock(HttpSession.class);
        model = mock(Model.class);
    }

    @Test
    public void shouldShowShoppingCarList() {
        when(httpSession.getAttribute(Constants.LOGIN_KEY)).thenReturn("1234");
        when(shoppingCartService.getPicListByUserId(anyString())).thenReturn(new ArrayList<Picture>());
        String actual = shoppingCartController.showShoppingCar(httpSession, model);
        assertThat(actual, is("shoppingCart"));
    }
}