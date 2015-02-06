package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.AddShoppingCartStatus;
import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.commons.json.ShoppingCartResponse;
import com.thoughtworks.spring.jpa.tomcat.controllers.mappers.ShoppingCartMapper;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/shopping-cart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String showShoppingCar(HttpSession httpSession, Model model) {
        String userId = httpSession.getAttribute(Constants.LOGIN_KEY).toString();

        List<Picture> picList = shoppingCartService.getPicListByUserId(userId);
        if (picList.size() == 0) {
            model.addAttribute("error", messageSource.getMessage("shopping_cart.empty", null, Locale.US));
        }
        model.addAttribute("picList", picList);
        model.addAttribute("totalPrice", getTotalPrice(picList));
        return "shoppingCart";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public ShoppingCartResponse addShoppingCar(HttpSession httpSession,
                                              @PathVariable(value = "id") String id) {
        String userId = httpSession.getAttribute(Constants.LOGIN_KEY).toString();
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
        if (userId.isEmpty()) {
            shoppingCartResponse.setStatus(AddShoppingCartStatus.NOT_LOGIN);
        }

        ShoppingCart shoppingCart = shoppingCartMapper.mapper(userId, id);
        shoppingCartResponse = shoppingCartService.addShoppingCar(shoppingCart);

        return shoppingCartResponse;
    }

    private int getTotalPrice(List<Picture> picList) {
        int totalPrice = 0;
        for (Picture picture : picList) {
            totalPrice += picture.getPrice();
        }
        return totalPrice;
    }
}
