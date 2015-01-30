package com.thoughtworks.spring.jpa.tomcat.controllers.mappers;

import com.thoughtworks.spring.jpa.tomcat.commons.UserStatus;
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
        java.util.Date date = new java.util.Date();

        User user = new User()
                .withFirstName(userForm.getFirstName())
                .withLastName(userForm.getLastName())
                .withEmail(userForm.getEmail())
                .withPassword(passwordEncoding.encode2hex(userForm.getPassword()))
                .withCreateDate(new Timestamp(date.getTime()))
                .withModifyDate(new Timestamp(date.getTime()))
                .withStatus(UserStatus.INACTIVE.name());
        return user;
    }
}
