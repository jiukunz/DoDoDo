package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qnxu on 1/27/15.
 */
@Component
public class PictureDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

    public Optional<Picture> parsePictureById(int id){
        TypedQuery<Picture> query = em.createQuery(
                "SELECT p FROM Picture p WHERE p.id=:id", Picture.class);
        query.setParameter("id",id);

        List<Picture> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return Optional.of(resultList.get(0));
        }
        return Optional.absent();
    }
}
