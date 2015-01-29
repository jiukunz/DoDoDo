package com.thoughtworks.spring.jpa.tomcat.services.impl;


import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import com.thoughtworks.spring.jpa.tomcat.services.EmailService;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    UserDao userDao;
    @Autowired
    EmailService emailService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    PasswordEncoding passwordEncoding;

    @Override
    public boolean register(User user) throws NoSuchAlgorithmException {
        if (Optional.absent().equals(userDao.selectUserByEmail(user.getEmail()))) {
            userDao.persist(user);
            emailService.sendConfirmEmail(user);
            return true;
        }
        return false;
    }

    public boolean active(String id){
        return userDao.active(id);
    }

    @Override
    public boolean validateUserEmail(String email) {
        Optional<User> optionalUser = userDao.selectUserByEmail(email);
        if (Optional.absent().equals(optionalUser)) {
            return false;
        }
        emailService.sendRecoveryEmail(optionalUser.get());
        return true;
    }

    @Override
    public boolean resetPassword(String id, String password) throws NoSuchAlgorithmException {
        String hashPass = passwordEncoding.encode2hex(password);
        if(userDao.updatePassword(id, hashPass)) {
            return true;
        }
        return false;
    }
}


