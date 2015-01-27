package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 * Created by qnxu on 1/27/15.
 */
@Controller
public class PictureController {
    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    public String showPicture(){
        return "picture";
    }
}
