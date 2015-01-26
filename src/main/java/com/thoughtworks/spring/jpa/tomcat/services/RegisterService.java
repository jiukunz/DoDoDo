package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;

    public void save(User user) {
        java.util.Date date= new java.util.Date();
        user.setCreateDate(new Timestamp(date.getTime()));
        user.setModifyDate(new Timestamp(date.getTime()));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.persist(user);
    }
}
