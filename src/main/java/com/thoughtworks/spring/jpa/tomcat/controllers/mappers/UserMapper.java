package com.thoughtworks.spring.jpa.tomcat.controllers.mappers;

import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Component
public class UserMapper {
    @Autowired
    PasswordEncoding passwordEncoding;

    public User Mapper(UserForm userForm) throws NoSuchAlgorithmException {
        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoding.encode2hex(userForm.getPassword()));

        java.util.Date date = new java.util.Date();
        user.setCreateDate(new Timestamp(date.getTime()));
        user.setModifyDate(new Timestamp(date.getTime()));
        return user;
    }
}
