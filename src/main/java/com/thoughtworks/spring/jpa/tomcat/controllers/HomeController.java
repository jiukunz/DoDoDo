package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.impl.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private PictureServiceImpl pictureService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage (Model model) {
        List<Picture> allPictures = pictureService.getFirstTenFeaturedPictures();
        model.addAttribute("picList", allPictures);

        List<Picture> newPictures = pictureService.getFirstTenNewPictures();
        model.addAttribute("size", newPictures.size());
        model.addAttribute("newPicList", newPictures);
        return "home";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public @ResponseBody Picture getPictureInformation(@RequestParam String pictureId){
        Picture picture = pictureService.findPicture(pictureId);

        return picture;
    }

    @RequestMapping(value = "/featuredPictures", method = RequestMethod.GET)
    public String showAllFeaturedPictures(Model model){
        List<Picture> featuredPicList = pictureService.getAllFeaturedPictures();
        if(featuredPicList.size() == 0){
            model.addAttribute("error", "No Featured Pictures");
        }else{
            model.addAttribute("featuredPicList", featuredPicList);
        }
        return "featuredPictures";
    }

    @RequestMapping(value = "/newPictures", method = RequestMethod.GET)
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
