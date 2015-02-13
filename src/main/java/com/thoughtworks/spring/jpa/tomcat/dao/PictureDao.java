package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public Optional<List<Picture>> getFirstTenFeaturedPictures() {
        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p", Picture.class);
        List<Picture> firstTenPicList = query.setMaxResults(10).getResultList();

        if(firstTenPicList.isEmpty()){
            return Optional.absent();
        }else {
            return Optional.of(firstTenPicList);
        }
    }

    public Optional<List<Picture>> getFirstTenNewPictures() {
        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p ORDER BY p.createDate DESC", Picture.class);
        List<Picture> firstTenNewPicList = query.setMaxResults(10).getResultList();

        if(firstTenNewPicList.isEmpty()){
            return Optional.absent();
        }else{
            return Optional.of(firstTenNewPicList);
        }
    }

    public Optional<List<Picture>> getAllFeaturedPictures() {
        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p", Picture.class);
        List<Picture> allFeaturedPicList = query.getResultList();

        if(allFeaturedPicList.isEmpty()){
            return Optional.absent();
        }else {
            return Optional.of(allFeaturedPicList);
        }
    }

    public Optional<List<Picture>> getAllNewPictures(){
        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p ORDER BY p.createDate DESC", Picture.class);
        List<Picture> allNewPictures = query.getResultList();

        if(allNewPictures.isEmpty()){
            return Optional.absent();
        }else{
            return Optional.of(allNewPictures);
        }
    }

    public Optional<List<Picture>> getPurchasedPicturesById(String userId) {
//        TypedQuery<Picture> query = em.createQuery("SELECT p FROM Picture p", Picture.class);

        List<Picture> purchasedPictures = new ArrayList<>();

        if(purchasedPictures.isEmpty()){
            return Optional.absent();
        }else{
            return Optional.of(purchasedPictures);
        }
    }
}
