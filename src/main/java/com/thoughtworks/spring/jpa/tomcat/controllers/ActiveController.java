package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dwwang on 1/28/15.
 */
@Controller
@RequestMapping(value = "/active")
public class ActiveController {
    @Autowired
    RegisterService registerService;
    @RequestMapping(method = RequestMethod.GET)
    public String login (@RequestParam(value = "code", required = true) String id){
        if(registerService.active(id)) {
            return "active";
        }else {
            return "error";
        }
    }
}
