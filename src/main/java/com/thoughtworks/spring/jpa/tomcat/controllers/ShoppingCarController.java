package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shopping_car")
public class ShoppingCarController {
    @RequestMapping(method = RequestMethod.GET)
    public String showShoppingCar(){
        return "shoppingCar.html";
    }
}
