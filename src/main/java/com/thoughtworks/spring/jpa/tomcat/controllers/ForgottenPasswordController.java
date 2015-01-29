package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/forgotten")
public class ForgottenPasswordController {
    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String showForgottenPage () {
        return "forgottenPassword";
    }
}
