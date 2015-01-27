package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qnxu on 1/27/15.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @RequestMapping( method = RequestMethod.GET)
    public String showPicture(Model model){
        model.addAttribute("message", "hello");
        return "picture";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public @ResponseBody String getPictureInformation(@RequestParam String imageName){

        return imageName;
    }
}
