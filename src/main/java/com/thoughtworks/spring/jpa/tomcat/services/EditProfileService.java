package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditProfileService {
    @Autowired
    private UserDao userDao;

    public User getUserById(String userId) {
        return userDao.selectUserById(userId).get();
    }

}
