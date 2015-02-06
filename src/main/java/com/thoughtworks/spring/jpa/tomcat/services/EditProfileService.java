package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.User;

/**
 * Created by qnxu on 2/6/15.
 */
public interface EditProfileService {
    public User getUserById(String userId);
    public int updateUserInformation(User user);
}
