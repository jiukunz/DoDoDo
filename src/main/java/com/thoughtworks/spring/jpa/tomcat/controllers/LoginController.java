package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginPage () {
        return "views/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login (@RequestParam(value = "username", required = true) String username,
                         @RequestParam(value = "password", required = true) String password) {

        return "";
    }
}
