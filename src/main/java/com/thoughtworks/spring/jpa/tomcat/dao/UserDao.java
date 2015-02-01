package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.commons.UserStatus;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Component
public class UserDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;
    private java.util.Date date = new java.util.Date();

    @Transactional
    public void persist(User user) {
        em.persist(user);
    }

    public Optional<User> selectUserByEmail(String email) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u where u.email=:email", User.class);
        query.setParameter("email", email);

        List<User> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return Optional.of(resultList.get(0));
        }

        return Optional.absent();
    }

    public Optional<User> selectUserById(String userId){
        Long id = Long.parseLong(userId);
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class);
        query.setParameter("id", id);

        List<User> resultList = query.getResultList();
        if(resultList.size() > 0)
            return Optional.of(resultList.get(0));
        return Optional.absent();
    }

    @Transactional
    public boolean active(String id) {
        Long pk=Long.parseLong(id);
        User user = em.find(User.class, pk);
        if(user!=null){
            user.setStatus(UserStatus.ACTIVE.name());
            user.setModifyDate(new Timestamp(date.getTime()));
            em.merge(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePassword(String id, String password) {
        Long pk = Long.parseLong(id);
        User user = em.find(User.class, pk);
        if(user != null && user.getStatus().equals(UserStatus.ACTIVE.name())) {
            user.setPassword(password);
            user.setModifyDate(new Timestamp(date.getTime()));
            em.merge(user);
            return true;
        }
        return false;
    }

    @Transactional
    public void updateUserInformation(User user) {
        TypedQuery<User> query = em.createQuery("UPDATE User u SET u.firstName = :firstName , u.lastName = :lastName" +
            " WHERE u.id = :id", User.class);
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("id", user.getId());

        query.executeUpdate();
    }
}
