package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Controller
@RequestMapping(value = "/reset/password")
public class ResetPasswordController {
    @Autowired
    RegisterService registerService;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String viewResetPage() {
        return "resetPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String resetPassword(@RequestParam(value = "password", required = true) String password,
                                @RequestParam(value = "confirmPassword", required = true) String confirmPassword,
                                @RequestParam(value = "code", required = true) String id,
                                Model model) throws NoSuchAlgorithmException {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", messageSource.getMessage("reset.password_failed", null, Locale.US));
            return "resetPassword";
        }
        if (registerService.resetPassword(id, password)) {
            return "resetSuccess";
        }
        return "resetPassword";
    }
}
