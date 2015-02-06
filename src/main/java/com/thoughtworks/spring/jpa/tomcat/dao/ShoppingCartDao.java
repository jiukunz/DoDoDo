package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.ShoppingCart;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ShoppingCartDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

    @Transactional
    public void persist(ShoppingCart shoppingCart) {
        em.persist(shoppingCart);
    }

    public Optional<List<ShoppingCart>> getShoppingCarByUserId(String id) {
        Long userId = Long.parseLong(id);
        TypedQuery<ShoppingCart> query = em.createQuery(
                "SELECT sc FROM ShoppingCart sc where sc.userId=:userId", ShoppingCart.class);
        query.setParameter("userId", userId);

        List<ShoppingCart> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return Optional.of(resultList);
        }

        return Optional.absent();
    }
}
