package com.thoughtworks.spring.jpa.tomcat.services.impl;


import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
import com.thoughtworks.spring.jpa.tomcat.services.EmailService;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    UserDao userDao;
    @Autowired
    EmailService emailService;
    @Autowired
    MessageSource messageSource;

    @Override
    public void register(User user) throws NoSuchAlgorithmException, EmailNotUniqueException {
        if (Optional.absent().equals(userDao.selectUserByEmail(user.getEmail()))) {
            userDao.persist(user);
            emailService.sendConfirmEmail(user);
        } else {
            throw new EmailNotUniqueException(messageSource.getMessage("register.already_register",new Object[]{user.getEmail()}, Locale.US));
        }
    }

    public boolean active(String id){
        return userDao.active(id);
    }
}


