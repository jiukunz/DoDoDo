package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;

    public void register(User user) throws NoSuchAlgorithmException {
        java.util.Date date = new java.util.Date();
        user.setCreateDate(new Timestamp(date.getTime()));
        user.setModifyDate(new Timestamp(date.getTime()));

        user.setPassword(encode2hex(user.getPassword()));
        userDao.persist(user);
    }

    private String encode2hex(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(0xff & digest[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}
