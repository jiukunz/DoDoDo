package com.thoughtworks.spring.jpa.tomcat.dao;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class UserDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

    @Transactional
    public void persist(User user) {
        em.persist(user);
    }

    public User selectUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u where u.email=:username", User.class);
        query.setParameter("username",username);
        return query.getSingleResult();
    }
}
