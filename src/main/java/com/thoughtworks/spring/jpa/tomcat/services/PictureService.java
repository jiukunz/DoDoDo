package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;

import java.util.List;

/**
 * Created by qnxu on 2/6/15.
 */
public interface PictureService {
    public Picture findPicture(String pictureId);
    public List<Picture> getPicturesByUserId(String userId);
    public List<Picture> getFirstTenFeaturedPictures();

    public List<Picture> getFirstTenNewPictures();

    public List<Picture> getAllFeaturedPictures();

    public List<Picture> getAllNewPictures();
}
