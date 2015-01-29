package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
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

    public boolean validateUser(String password, Optional<User> userOptional) throws NoSuchAlgorithmException {
        return userOptional.isPresent() && Objects.equals(userOptional.get().getPassword(), passwordEncoding.encode2hex(password));
    }

    public Optional<User> getByEmail(String username) {
        return userDao.selectUserByEmail(username);
    }
}
