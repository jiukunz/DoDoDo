package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class homeController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage () {
        return "home";
    }
}
