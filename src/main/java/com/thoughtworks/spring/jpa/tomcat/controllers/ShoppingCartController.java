
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (null == picList || picList.isEmpty()) {
            model.addAttribute("error", messageSource.getMessage("shopping_cart.empty", null, Locale.US));
            return "shoppingCart";
        }
        model.addAttribute("picList", picList);
        model.addAttribute("totalPrice", getTotalPrice(picList));
        return "shoppingCart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody ShoppingCartResponse addShoppingCar(HttpSession httpSession,
           @RequestParam(value = "picture_id", required = true) String picture_id) {
        Object userId = httpSession.getAttribute(Constants.LOGIN_KEY);
        ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse();
        if (null == userId) {
            shoppingCartResponse.setStatus(AddShoppingCartStatus.NOT_LOGIN);
            return shoppingCartResponse;
        }

        ShoppingCart shoppingCart = shoppingCartMapper.mapper((String)userId, picture_id);
        shoppingCartResponse = shoppingCartService.addShoppingCar(shoppingCart);

        return shoppingCartResponse;
    }

    private int getTotalPrice(List<Picture> picList) {
        int totalPrice = 0;
        if(picList.isEmpty()) {
            return totalPrice;
        }
        for (Picture picture : picList) {
            totalPrice += picture.getPrice();
        }
        return totalPrice;
    }
}
