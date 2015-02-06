package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.Option;
import java.util.List;

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

    public Optional<List<Picture>> getPicturesByUserId(String id) {
        Long user_id = Long.parseLong(id);

        TypedQuery<Picture> query = em.createQuery("SELECT pic FROM Picture pic WHERE pic.user_id=:user_id", Picture.class);
        query.setParameter("user_id", user_id);
        List<Picture> picList = query.getResultList();

        if (picList.isEmpty()) {
            return Optional.absent();
        }else{
            return Optional.of(picList);
        }

    }

    public Optional<List<Picture>> getAllPictures() {
        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p", Picture.class);
        List<Picture> allPicList = query.getResultList();

        if(allPicList.isEmpty()){
            return Optional.absent();
        }else {
            return Optional.of(allPicList);
        }
    }

}
