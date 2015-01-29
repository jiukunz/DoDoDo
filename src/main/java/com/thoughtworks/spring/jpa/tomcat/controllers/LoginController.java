package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Controller
public class LoginController {

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
        Optional<User> userOptional = loginService.getByEmail(username);
        if (loginService.validateUser(password, userOptional)) {
            httpSession.setAttribute(Constants.LOGIN_KEY, userOptional.get().getId().toString());
            return "redirect:/home";//TODO: finish homePage by 8k
        }
        else {
            model.addAttribute("error", messageSource.getMessage("login.login_failed", null, Locale.US));
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody String postLogout(HttpSession httpSession)
    {
        httpSession.removeAttribute(Constants.LOGIN_KEY);
        return "ok";
    }
}
