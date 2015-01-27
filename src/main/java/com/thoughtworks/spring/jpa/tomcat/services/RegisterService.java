package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;

    public void register(User user) throws NoSuchAlgorithmException, EmailNotUniqueException {
        if (userDao.selectUserByEmail(user.getEmail()) == null) {
            userDao.persist(user);
        } else {
            throw new EmailNotUniqueException("This email address has been registered.");
        }
    }

}
