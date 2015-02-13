package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAdminPage(Model model){
        int registeredUserCount = adminService.getRegisteredUserCount();
        int activeUserCount = adminService.getActiveUserCount();

        model.addAttribute("registeredUserCount", registeredUserCount);
        model.addAttribute("activeUserCount", activeUserCount);

        return "admin";
    }


}
