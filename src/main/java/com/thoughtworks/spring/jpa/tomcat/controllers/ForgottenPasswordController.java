package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping(value = "/forgotten/password")
public class ForgottenPasswordController {
    @Autowired
    RegisterService registerService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String showForgottenPage() {
        return "forgottenPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String forgottenPassword(@RequestParam(value = "email", required = true) String email,
                                    Model model) {
        if (!registerService.validateUserEmail(email)) {
            model.addAttribute("error", messageSource.getMessage("reset.email_not_registered", new Object[]{email}, Locale.US));
            return "forgottenPassword";
        }
        return "resetEmailSend";
    }
}
