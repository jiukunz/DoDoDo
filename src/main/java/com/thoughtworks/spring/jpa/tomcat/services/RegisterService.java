package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;

import java.security.NoSuchAlgorithmException;

public interface RegisterService {
    public void register(User user) throws EmailNotUniqueException, NoSuchAlgorithmException;
    public boolean active(String id);
}
