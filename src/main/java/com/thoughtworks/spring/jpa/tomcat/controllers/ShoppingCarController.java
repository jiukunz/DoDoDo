package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/shopping_car")
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String showShoppingCar(HttpSession httpSession, Model model){
        String userId = httpSession.getAttribute(Constants.LOGIN_KEY).toString();

        List<Picture> picList = shoppingCarService.getPicListByUserId(userId);
        if(picList.size() == 0){
            model.addAttribute("error",  messageSource.getMessage("shopping_car.empty", null, Locale.US));
        }
        model.addAttribute("picList", picList);
        model.addAttribute("totalPrice", getTotalPrice(picList));
        return "shoppingCar";
    }

    private int getTotalPrice(List<Picture> picList) {
        int totalPrice = 0;
        for(Picture picture : picList){
            totalPrice += picture.getPrice();
        }
        return totalPrice;
    }
}
