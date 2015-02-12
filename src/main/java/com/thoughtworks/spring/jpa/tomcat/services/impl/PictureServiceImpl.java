package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qnxu on 1/27/15.
 */
@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureDao pictureDao;

    @Override
    public Picture findPicture(String pictureId){
        Optional<Picture> pictureOptional =  pictureDao.getPicById(pictureId);

        return pictureOptional.get();
    }

    @Override
    public List<Picture> getPicturesByUserId(String userId) {
        List<Picture> pictures = new ArrayList<>();
        Optional<List<Picture>> picListOptional = pictureDao.getPicturesByUserId(userId);

        if(picListOptional.isPresent()){
            pictures = picListOptional.get();
        }

        return pictures;
    }

    @Override
    public List<Picture> getFirstTenFeaturedPictures() {
        List<Picture> featuredPicList = new ArrayList<>();
        Optional<List<Picture>> featuredPicListOptional = pictureDao.getFirstTenFeaturedPictures();

        if(featuredPicListOptional.isPresent()){
            featuredPicList = featuredPicListOptional.get();
        }
        return featuredPicList;
    }

    @Override
    public List<Picture> getFirstTenNewPictures() {
        List<Picture> newPictures = new ArrayList<>();
        Optional<List<Picture>> newPicListOptional = pictureDao.getFirstTenNewPictures();

        if(newPicListOptional.isPresent()){
            newPictures = newPicListOptional.get();
        }
        return newPictures;
    }

    @Override
    public List<Picture> getAllFeaturedPictures() {
        List<Picture> featuredPicList = new ArrayList<>();
        Optional<List<Picture>> featuredPicListOptional = pictureDao.getAllFeaturedPictures();

        if(featuredPicListOptional.isPresent()){
            featuredPicList = featuredPicListOptional.get();
        }
        return featuredPicList;
    }

    @Override
    public List<Picture> getAllNewPictures() {
        List<Picture> newPicList = new ArrayList<>();
        Optional<List<Picture>> newPicListOptional = pictureDao.getAllNewPictures();

        if(newPicListOptional.isPresent()){
            newPicList = newPicListOptional.get();
        }
        return newPicList;
    }


}
