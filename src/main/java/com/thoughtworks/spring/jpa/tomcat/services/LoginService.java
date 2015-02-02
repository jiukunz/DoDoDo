package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.commons.UserStatus;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Component
public class LoginService {

    public static final String LOGIN_LOGIN_FAILED = "login.login_failed";
    public static final String LOGIN_ACCOUNT_INACTIVE = "login.account_inactive";
    @Autowired
    UserDao userDao;
    private User loginUser;

    @Autowired
    PasswordEncoding passwordEncoding;

    public boolean validateUserPassword(String password, Optional<User> userOptional) throws NoSuchAlgorithmException {
        return userOptional.isPresent() && Objects.equals(userOptional.get().getPassword(), passwordEncoding.encode2hex(password));
    }

    public Optional<User> getByEmail(String username) {
        return userDao.selectUserByEmail(username);
    }

    public Boolean validateUserStatus(Optional<User> optionalUser) {
        return Objects.equals(optionalUser.get().getStatus(), UserStatus.ACTIVE.name());
    }

    public String getErrorMessage(String password, Optional<User> userOptional) throws NoSuchAlgorithmException {
        if (!validateUserPassword(password,userOptional)) {
            return LOGIN_LOGIN_FAILED;
        }
        if (!validateUserStatus(userOptional)) {
            return LOGIN_ACCOUNT_INACTIVE;
        }
        return null;
    }

    public void persistUser(User user) {
        loginUser = user;
    }

    public User getLoginUser () {
        return loginUser;
    }
}
