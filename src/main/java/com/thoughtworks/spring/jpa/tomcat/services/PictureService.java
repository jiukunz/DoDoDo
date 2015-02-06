package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qnxu on 1/27/15.
 */
@Component
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public Picture findPicture(String pictureId){
        Optional<Picture> pictureOptional =  pictureDao.getPicById(pictureId);

        return pictureOptional.get();
    }

    public List<Picture> getPicturesByUserId(String userId) {
        List<Picture> pictures = new ArrayList<>();
        Optional<List<Picture>> picListOptional = pictureDao.getPicturesByUserId(userId);

        if(picListOptional.isPresent()){
            pictures = picListOptional.get();
        }

        return pictures;
    }
}
