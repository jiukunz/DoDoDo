package com.thoughtworks.spring.jpa.tomcat.dao;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AdminDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;


    public int getRegisteredUserCount() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> userList = query.getResultList();

        return userList.size();
    }

    public int getActiveUserCount() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.status='ACTIVE'", User.class);
        List<User> activeUserList = query.getResultList();

        return activeUserList.size();
    }
}
