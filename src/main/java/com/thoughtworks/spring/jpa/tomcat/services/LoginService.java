package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Component
public class LoginService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoding passwordEncoding;

    public boolean validateUser(String username, String password) throws NoSuchAlgorithmException {
        return userDao.selectUserByEmail(username).isPresent() && Objects.equals(userDao.selectUserByEmail(username).get().getPassword(), passwordEncoding.encode2hex(password));
    }
}
