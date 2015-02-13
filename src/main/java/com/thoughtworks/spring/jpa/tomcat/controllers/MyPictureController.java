package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.PictureService;
import com.thoughtworks.spring.jpa.tomcat.services.impl.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "myPicture", method = RequestMethod.GET)
    public String showPicturePage(HttpSession httpSession, ModelMap modelMap){
        String userId = (String) httpSession.getAttribute(Constants.LOGIN_KEY);

        List<Picture> uploadedPicList = pictureService.getUploadedPicListByUserId(userId);
        if(uploadedPicList.size() == 0){
            modelMap.addAttribute("uploadedError",  "Please upload picture first");
        }else{
            modelMap.addAttribute("uploadedPicList", uploadedPicList);
        }

        List<Picture> purchasedPicList = pictureService.getPurchasedPicListByUserId(userId);
        if(purchasedPicList.size() == 0){
            modelMap.addAttribute("purchasedError", "You haven't purchased any pictures." );
        }else{
            modelMap.addAttribute("purchasedPicList", purchasedPicList);
        }

        return "myPicture";
    }

}
