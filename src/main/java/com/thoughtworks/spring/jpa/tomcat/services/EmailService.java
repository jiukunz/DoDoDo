package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.User;

/**
 * Created by dwwang on 1/28/15.
 */
public interface EmailService {
    void sendConfirmEmail(User user);
    void sendRecoveryEmail(User user);
}
