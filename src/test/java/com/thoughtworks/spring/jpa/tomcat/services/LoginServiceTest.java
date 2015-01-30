package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.commons.UserStatus;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginServiceTest {
    @InjectMocks
    LoginService loginService;
    @Mock
    UserDao userDao;
    @Mock
    PasswordEncoding passwordEncoding;
    private String email;
    private String password;
    private User user;
    Optional<User> optionalUser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        email = "username";
        password = "123456";
        user = new User();
        optionalUser = Optional.of(user);
    }

    @Test
    public void shouldReturnTrueWhenUserIsCorrect() throws Exception {
        user.setPassword(password);
        when(passwordEncoding.encode2hex(password)).thenReturn(password);
        Boolean actual = loginService.validateUserPassword(password, optionalUser);
        Boolean expect = true;

        assertThat(actual, is(expect));
    }

    @Test
    public void shouldReturnFalseWhenUserIsIncorrect() throws Exception {
        user.setPassword(password);
        when(passwordEncoding.encode2hex(password)).thenReturn(password);
        String incorrectPassword = "111111";
        Boolean actual = loginService.validateUserPassword(incorrectPassword, optionalUser);
        Boolean expect = false;

        assertThat(actual, is(expect));
    }

    @Test
    public void shouldReturnFalseWhenUserIsInactive() throws Exception {
        user.setStatus(UserStatus.INACTIVE.name());

        Boolean actual = loginService.validateUserStatus(optionalUser);
        Boolean expect = false;

        assertThat(actual, is(expect));
    }

    @Test
    public void shouldReturnTrueWhenUserIsActive() throws Exception {
        user.setStatus(UserStatus.ACTIVE.name());

        Boolean actual = loginService.validateUserStatus(optionalUser);

        assertThat(actual, is(true));
    }

    @Test
    public void shouldReturnLOGIN_LOGIN_FAILEDWhenUserIsIncorrect() throws Exception {
        when(loginService.validateUserPassword(anyString(),optionalUser)).thenReturn(false);
        String actual = loginService.getErrorMessage(anyString(), optionalUser);

        assertThat(actual, is("login.login_failed"));
    }

    @Test
    public void shouldReturnLOGIN_ACCOUNT_INACTIVEWhenUserIsInactive() throws Exception {
        when(loginService.validateUserStatus(optionalUser)).thenReturn(false);
        String actual = loginService.getErrorMessage(anyString(), optionalUser);

        assertThat(actual, is("login.account_inactive"));
    }
}
