package com.thoughtworks.spring.jpa.tomcat.services;

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

    public void getPictureInformation(int pictureId){
        pictureDao.parsePictureById(pictureId);
    }
}
