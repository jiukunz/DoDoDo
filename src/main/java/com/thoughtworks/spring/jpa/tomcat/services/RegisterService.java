package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
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

    public void register(UserForm userForm) throws NoSuchAlgorithmException, EmailNotUniqueException {
        User newUser = createUser(userForm);
        if (userDao.selectUserByEmail(userForm.getEmail()) == null) {
            userDao.persist(newUser);
        } else {
            throw new EmailNotUniqueException("This email address has been registered.");
        }
    }

    private User createUser(UserForm user) throws NoSuchAlgorithmException {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoding.encode2hex(user.getPassword()));

        java.util.Date date = new java.util.Date();
        newUser.setCreateDate(new Timestamp(date.getTime()));
        newUser.setModifyDate(new Timestamp(date.getTime()));
        return newUser;
    }
}
