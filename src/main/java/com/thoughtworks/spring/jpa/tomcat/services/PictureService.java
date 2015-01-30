package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qnxu on 1/27/15.
 */
@Component
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public Map<String, String> getPictureInformation(String pictureId){
        Picture picture =  pictureDao.parsePictureById(pictureId).get();
        Map<String, String> pictureInformation = new HashMap<>();
        pictureInformation.put("name",picture.getCaption());
        pictureInformation.put("description",picture.getKeyword());
        return pictureInformation;
    }
}
