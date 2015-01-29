package com.thoughtworks.spring.jpa.tomcat.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.MockitoAnnotations.initMocks;

public class ForgottenPasswordControllerTest {
    @InjectMocks
    ForgottenPasswordController forgottenPasswordController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldShowForgottenPasswordPage() {
        String actual = forgottenPasswordController.showForgottenPage();
        assertThat(actual, is("forgottenPassword"));
    }
}