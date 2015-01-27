package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginPage () {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login (@RequestParam(value = "username", required = true) String username,
                         @RequestParam(value = "password", required = true) String password,
                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) throws NoSuchAlgorithmException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        if (loginService.validateUser(username, password)) {
            httpSession.setAttribute("LOGIN_STATUS", LOGIN);
            httpServletResponse.sendRedirect("/home");
            return "home";//TODO: add a homePage
        }
        else {
            httpSession.setAttribute("loginStatus", LOGOUT);
            model.addAttribute("error", "Your username or password is not correct");
            return "login";
        }
    }
}
