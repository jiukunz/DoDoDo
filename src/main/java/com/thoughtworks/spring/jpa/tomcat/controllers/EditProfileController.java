package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.EditProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profile")
public class EditProfileController {
    @Autowired
    private EditProfileService editProfileService;

    @RequestMapping(method = RequestMethod.GET)
    public String showProfilePage(HttpSession httpSession, Model model){
        String userId = (String) httpSession.getAttribute(Constants.LOGIN_KEY);
        User user = editProfileService.getUserById(userId);
        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveEditedProfile(@RequestParam(value = "firstName", required = true) String firstName,
                                    @RequestParam(value = "lastName", required = true) String lastName, HttpSession httpSession){
        String userId = (String)httpSession.getAttribute(Constants.LOGIN_KEY);
        User user = new User(Long.parseLong(userId), firstName, lastName);
        editProfileService.updateUserInformation(user);

        return "home";
    }

}
