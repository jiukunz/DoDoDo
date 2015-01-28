package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.exceptions.EmailNotUniqueException;
import com.thoughtworks.spring.jpa.tomcat.services.EmailService;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RegisterServiceImplTest {
    @InjectMocks
    RegisterService registerService = new RegisterServiceImpl();

    @Mock
    EmailService emailService;

    @Mock
    UserDao userDao;

    @Mock
    MessageSource messageSource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldPersistUserWhenRegistrationSuccess() throws EmailNotUniqueException, NoSuchAlgorithmException {
        User user = getUser();
        when(userDao.selectUserByEmail(anyString())).thenReturn(Optional.<User>absent());
        registerService.register(user);
        verify(userDao).persist(user);
        verify(emailService).sendConfirmEmail(user);
    }

    @Test(expected = EmailNotUniqueException.class)
    public void shouldThrowEmailNotUniqueExceptionWhenEmailHasBeenRegistered() throws EmailNotUniqueException, NoSuchAlgorithmException {
        User user = getUser();
        when(userDao.selectUserByEmail(anyString())).thenReturn(Optional.of(new User()));
        registerService.register(user);
    }

    public User getUser() {
        User user = new User();
        user.setFirstName("Jiukun");
        user.setLastName("Zhang");
        user.setEmail("jkzhang@gmail.com");
        user.setPassword("123456");
        java.util.Date date = new java.util.Date();
        user.setCreateDate(new Timestamp(date.getTime()));
        user.setModifyDate(new Timestamp(date.getTime()));
        return user;
    }
}