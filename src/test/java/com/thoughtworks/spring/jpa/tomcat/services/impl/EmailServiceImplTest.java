package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.EmailService;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.sql.Timestamp;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmailServiceImplTest {
    @InjectMocks
    EmailService emailService = new EmailServiceImpl();
    @Mock
    private JavaMailSender mailSender;
    @Mock
    private VelocityEngine velocityEngine;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldSendConfirmEmail() {
        User user = getUser();
        emailService.sendConfirmEmail(user);
        verify(mailSender).send(any(MimeMessagePreparator.class));
    }

    @Test
    public void shouldSendRecoveryEmail() {
        User user = getUser();
        emailService.sendRecoveryEmail(user);
        verify(mailSender).send(any(MimeMessagePreparator.class));
    }

    public User getUser() {
        java.util.Date date = new java.util.Date();
        User user = new User()
                .withFirstName("Jiukun")
                .withLastName("Zhang")
                .withEmail("jkzhang@gmail.com")
                .withPassword("123456")
                .withCreateDate(new Timestamp(date.getTime()))
                .withModifyDate(new Timestamp(date.getTime()));
        return user;
    }
}