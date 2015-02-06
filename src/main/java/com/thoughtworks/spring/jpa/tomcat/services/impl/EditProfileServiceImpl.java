package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.EditProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EditProfileServiceImpl implements EditProfileService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(String userId) {
        return userDao.selectUserById(userId).get();
    }

    @Override
    public int updateUserInformation(User user) {
        return userDao.updateUserInformation(user);
    }
}
