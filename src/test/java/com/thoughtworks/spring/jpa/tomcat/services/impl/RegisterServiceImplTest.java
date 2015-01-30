package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
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
    public void shouldPersistUserWhenRegistrationSuccess() throws NoSuchAlgorithmException {
        User user = getUser();
        when(userDao.selectUserByEmail(anyString())).thenReturn(Optional.<User>absent());
        registerService.register(user);
        verify(userDao).persist(user);
        verify(emailService).sendConfirmEmail(user);
    }

    @Test
    public void shouldThrowEmailNotUniqueExceptionWhenEmailHasBeenRegistered() throws NoSuchAlgorithmException {
        User user = getUser();
        when(userDao.selectUserByEmail(anyString())).thenReturn(Optional.of(new User()));
        registerService.register(user);
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