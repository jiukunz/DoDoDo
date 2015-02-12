package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;

import java.util.List;

/**
 * Created by qnxu on 2/6/15.
 */
public interface PictureService {
    public Picture findPicture(String pictureId);
    public List<Picture> getPicturesByUserId(String userId);
    public List<Picture> getAllPictures();

    public List<Picture> getNewPictures();
}
