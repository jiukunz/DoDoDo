package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
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

    public Picture findPicture(String pictureId){
        Picture picture =  pictureDao.getPicById(pictureId).get();

        if(picture.equals(Optional.absent())){
            return new Picture("0",Long.parseLong("0"),"caption","location","keyword",0);
        }

        return picture;
    }
}
