package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.controllers.mappers.UserMapper;
import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("userForm") UserForm userForm,
                                      BindingResult result,
                                      Model model) throws NoSuchAlgorithmException {

        if (result.hasErrors() || !userForm.getPassword().equals(userForm.getConfirmPassword())){
            model.addAttribute("error", messageSource.getMessage("register.register_failed",null, Locale.US));
            model.addAttribute("userForm", userForm);
            return "registration";
        }

        try {
            User user = userMapper.Mapper(userForm);
            registerService.register(user);
        }catch (EmailNotUniqueException e){
            model.addAttribute("error", e.getMessage());
            return "registration";
        }
        return "registrationSuccess";
    }
}
