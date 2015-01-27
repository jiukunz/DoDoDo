package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                                      BindingResult result,
                                      Model model) throws NoSuchAlgorithmException {

        if (result.hasErrors() || !userForm.getPassword().equals(userForm.getConfirmPassword())){
            model.addAttribute("error", "Registration unsuccessful, please checkout your information.");
            model.addAttribute("userForm", userForm);
            return "registration";
        }

        try {
            registerService.register(userForm);
        }catch (EmailNotUniqueException e){
            model.addAttribute("error", e.getMessage());
            return "registration";
        }
        return "registrationSuccess";
    }
}
