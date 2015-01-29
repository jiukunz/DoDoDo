package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.User;

import java.security.NoSuchAlgorithmException;

public interface RegisterService {
    public boolean register(User user) throws NoSuchAlgorithmException;
    public boolean active(String id);
    public boolean validateUserEmail(String email);
    public boolean resetPassword(String id, String password) throws NoSuchAlgorithmException;
}
