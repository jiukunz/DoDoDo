package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoding passwordEncoding;

    public void register(User user) throws NoSuchAlgorithmException {
        java.util.Date date = new java.util.Date();
        user.setCreateDate(new Timestamp(date.getTime()));
        user.setModifyDate(new Timestamp(date.getTime()));

        user.setPassword(passwordEncoding.encode2hex(user.getPassword()));
        userDao.persist(user);
    }
}
