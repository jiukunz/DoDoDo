package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.impl.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PictureController {
    @Autowired
    private PictureServiceImpl pictureService;

    @RequestMapping(value = "picture", method = RequestMethod.GET)
    public String showPicturePage(HttpSession httpSession, ModelMap modelMap){
        String userId = (String) httpSession.getAttribute(Constants.LOGIN_KEY);

        List<Picture> picList = pictureService.getPicturesByUserId(userId);
        if(picList.size() == 0){
            modelMap.addAttribute("error",  "Please upload picture first");
        }
        modelMap.addAttribute("picList", picList);

        return "picture";
    }

    @RequestMapping(value = "featuredPictures", method = RequestMethod.GET)
    public String showAllFeaturedPictures(Model model){
        List<Picture> featuredPicList = pictureService.getAllFeaturedPictures();
        if(featuredPicList.size() == 0){
            model.addAttribute("error", "No Featured Pictures");
        }else{
            model.addAttribute("featuredPicList", featuredPicList);
        }
        return "featuredPictures";
    }

    @RequestMapping(value = "newPictures", method = RequestMethod.GET)
    public String showAllNewPictures(Model model){
        List<Picture> newPicList = pictureService.getAllNewPictures();
        if(newPicList.size() == 0){
            model.addAttribute("error", "No New Pictures");
        }else{
            model.addAttribute("newPicList", newPicList);
        }
        return "newPictures";
    }

}
