package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ResetPasswordControllerTest {
    @InjectMocks
    ResetPasswordController resetPasswordController;
    @Mock
    Model model;
    @Mock
    RegisterService registerService;
    @Mock
    MessageSource messageSource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnResetSuccessWhenResetPasswordSuccess() throws NoSuchAlgorithmException {
        String password = "123456";
        String confirmPassword = "123456";
        String id = "123";
        when(registerService.resetPassword(anyString(), anyString())).thenReturn(true);
        String actual = resetPasswordController.resetPassword(password, confirmPassword,id, model);
        assertThat(actual, is("resetSuccess"));
    }

    @Test
    public void shouldReturnResetPasswordWhenPasswordNotEqualsConfirmPassword() throws NoSuchAlgorithmException {
        String password = "123456";
        String confirmPassword = "654321";
        String id = "123";
        when(registerService.resetPassword(anyString(), anyString())).thenReturn(true);
        String actual = resetPasswordController.resetPassword(password, confirmPassword,id, model);
        assertThat(actual, is("resetPassword"));
    }

    @Test
    public void shouldReturnResetPasswordWhenResetPasswordFailure() throws NoSuchAlgorithmException {
        String password = "123456";
        String confirmPassword = "123456";
        String id = "123";
        when(registerService.resetPassword(anyString(), anyString())).thenReturn(false);
        String actual = resetPasswordController.resetPassword(password, confirmPassword,id, model);
        assertThat(actual, is("resetPassword"));
    }
}