package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoginService {

    @Autowired
    UserDao userDao;

    public boolean validateUser(String username, String password) {
        return Objects.equals(userDao.selectUserByUsername(username).getPassword(), password);
    }
}
