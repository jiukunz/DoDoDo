package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import com.thoughtworks.spring.jpa.tomcat.services.EmailService;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Mock
    PasswordEncoding passwordEncoding;

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

    @Test
    public void shouldReturnTrueWhenResetPasswordSuccess() throws NoSuchAlgorithmException {
        String id = "1234";
        String password = "123456";
        when(userDao.updatePassword(anyString(),anyString())).thenReturn(true);
        assertTrue(registerService.resetPassword(id, password));
    }
    @Test
    public void shouldReturnFalseWhenResetPasswordFailure() throws NoSuchAlgorithmException {
        String id = "1234";
        String password = "123456";
        when(userDao.updatePassword(anyString(),anyString())).thenReturn(false);
        assertFalse(registerService.resetPassword(id, password));
    }
}