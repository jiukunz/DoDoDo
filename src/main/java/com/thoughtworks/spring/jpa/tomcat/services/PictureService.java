package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;

/**
 * Created by qnxu on 1/27/15.
 */
@Component
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public Picture getPictureInformation(int pictureId){
        Picture picture =  pictureDao.parsePictureById(pictureId);
        return picture;
    }
}
