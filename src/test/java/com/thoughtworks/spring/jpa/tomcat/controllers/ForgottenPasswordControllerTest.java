package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ForgottenPasswordControllerTest {
    @InjectMocks
    ForgottenPasswordController forgottenPasswordController;
    @Mock
    Model model;
    @Mock
    MessageSource messageSource;
    @Mock
    RegisterService registerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldShowForgottenPasswordPage() {
        String actual = forgottenPasswordController.showForgottenPage();
        assertThat(actual, is("forgottenPassword"));
    }

    @Test
    public void shouldStayOnForgottenPageWhenEmailNotExist() {
        String email = "jkzhang@gmail.com";
        when(registerService.validateUserEmail(anyString())).thenReturn(false);
        String actual = forgottenPasswordController.forgottenPassword(email, model);
        assertThat(actual, is("forgottenPassword"));

    }
    @Test
    public void shouldReturnResetEmailSendWhenEmailExist() {
        String email = "jkzhang@gmail.com";
        when(registerService.validateUserEmail(anyString())).thenReturn(true);
        String actual = forgottenPasswordController.forgottenPassword(email, model);
        assertThat(actual, is("resetEmailSend"));

    }
}