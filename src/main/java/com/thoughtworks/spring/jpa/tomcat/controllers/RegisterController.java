package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(
            @ModelAttribute("userForm") User user,
            @RequestParam(value="confirmPassword") String confirmPassword,
            Model model) throws NoSuchAlgorithmException {
        if(user.getPassword().equals(confirmPassword)) {
            registerService.register(user);
            return "registrationSuccess";
        }else{
            model.addAttribute("confirmError", "These passwords don't match. Try again?");
        }
        return "registration";
    }
}
