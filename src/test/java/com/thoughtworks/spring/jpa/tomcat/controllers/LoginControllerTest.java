package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;
    @Mock
    private LoginService loginService;
    @Mock
    MessageSource messageSource;

    private String username;
    private String password;
    private Model model;
    private HttpSession httpSession;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        username = "username";
        password = "password";
        httpSession = mock(HttpSession.class);
        model = mock(Model.class);
    }

    @Test
    public void shouldReturnLoginWhenLoginInvalidate() throws Exception {
        when(loginService.validateUser(username, password)).thenReturn(false);

        String actualUrl = loginController.login(username, password, httpSession, model);
        String expectUrl = "login";

        assertThat(actualUrl, is(expectUrl));
    }

    @Test
    public void shouldReturnHomeWhenLoginValidate() throws Exception {
        when(loginService.validateUser(username, password)).thenReturn(true);

        String actualUrl = loginController.login(username, password, httpSession, model);
        String expectUrl = "redirect:/home";

        assertThat(actualUrl, is(expectUrl));
    }
}