package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping( method = RequestMethod.GET)
    public String showPicturePage(HttpSession httpSession, Model model){
        String userId = (String) httpSession.getAttribute(Constants.LOGIN_KEY);

        List<Picture> picList = pictureService.getPicturesByUserId(userId);
        if(picList.size() == 0){
            model.addAttribute("error",  "Please upload picture first");
        }
        model.addAttribute("picList", picList);

        return "picture";
    }
}
