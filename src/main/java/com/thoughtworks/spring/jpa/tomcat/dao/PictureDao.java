package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by qnxu on 1/27/15.
 */
@Component
public class PictureDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

    public Optional<Picture> getPicById(String id){
        Picture picture = em.find(Picture.class, id);
        if (picture!=null) {
            return Optional.of(picture);
        }
        return Optional.absent();
    }

    @Transactional
    public void insertPicInfo(Picture pictureEntity) {
        em.persist(pictureEntity);
    }
}
