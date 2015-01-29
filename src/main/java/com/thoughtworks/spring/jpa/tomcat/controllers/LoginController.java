package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Controller
public class LoginController {

    private static final String LOGIN = "login";
    private static final String LOGOUT = "logout";
    @Autowired
    LoginService loginService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage () {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (@RequestParam(value = "username", required = true) String username,
                         @RequestParam(value = "password", required = true) String password,
                         HttpSession httpSession, Model model) throws NoSuchAlgorithmException, IOException {
        if (loginService.validateUser(username, password)) {
            httpSession.setAttribute("LOGIN_STATUS", LOGIN);
            return "redirect:/home";//TODO: add a homePage
        }
        else {
            httpSession.setAttribute("LOGIN_STATUS", LOGOUT);
            model.addAttribute("error", messageSource.getMessage("login.login_failed",null, Locale.US));
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String postLogout (@RequestParam(value = "status", required = true) String status, HttpSession httpSession)
    {
        httpSession.setAttribute("LOGIN_STATUS", status);
        return "redirect:/login";
    }
}
