package com.thoughtworks.spring.jpa.tomcat.dao;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDao {
    @PersistenceContext(name = "postgres")
    private EntityManager em;

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
}
