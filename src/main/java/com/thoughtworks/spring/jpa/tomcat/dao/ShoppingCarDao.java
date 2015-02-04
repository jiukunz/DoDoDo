package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCar;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ShoppingCarDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

    public Optional<List<ShoppingCar>> getShoppingCarByUserId(String id) {
        Long userId = Long.parseLong(id);
        TypedQuery<ShoppingCar> query = em.createQuery(
                "SELECT sc FROM ShoppingCar sc where sc.userId=:userId", ShoppingCar.class);
        query.setParameter("userId", userId);

        List<ShoppingCar> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return Optional.of(resultList);
        }

        return Optional.absent();
    }
}
