package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        UserForm userForm = new UserForm();
        model.put("userForm", userForm);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("userForm") UserForm userForm,
                                      BindingResult result) throws NoSuchAlgorithmException {

        if (result.hasErrors()){
            return "registration";
        }

        registerService.register(userForm);
        return "registrationSuccess";
    }
}
