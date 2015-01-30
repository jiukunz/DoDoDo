package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.controllers.mappers.UserMapper;
import com.thoughtworks.spring.jpa.tomcat.controllers.views.UserForm;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RegisterControllerTest {

    @InjectMocks
    RegisterController registerController;
    @Mock
    RegisterService registerService;
    @Mock
    private UserMapper userMapper;
    @Mock
    MessageSource messageSource;
    
    private BindingResult result;
    private Model model;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        model = mock(Model.class);
        userMapper = mock(UserMapper.class);
        result = mock(BindingResult.class);
    }

    @Test
    public void shouldDirectToRegistrationPage() {
        String actual = registerController.viewRegistration();
        assertThat(actual, is("registration.html"));
    }

    @Test
    public void shouldDirectToRegistrationSuccessPageWhenSignUpSuccess() throws NoSuchAlgorithmException {
        UserForm userForm = getValidUserForm();
        when(result.hasErrors()).thenReturn(false);
        when(registerService.register(any(User.class))).thenReturn(true);
        String actual = registerController.processRegistration(userForm, result, model);
        assertThat(actual, is("registrationSuccess.html"));
    }

    @Test
    public void shouldDirectToRegistrationPageWhenUserInfoInvalidate() throws NoSuchAlgorithmException {
        UserForm userForm = getInValidUserForm();
        when(result.hasErrors()).thenReturn(true);
        String actual = registerController.processRegistration(userForm, result, model);
        assertThat(actual, is("registration.html"));
    }

    @Test
    public void shouldDirectToRegistrationPageWhenComfirmPasswordNotEqualsPassword() throws NoSuchAlgorithmException {
        UserForm userForm = getPasswordInValidUserForm();
        String actual = registerController.processRegistration(userForm, result, model);
        assertThat(actual, is("registration.html"));
    }


    @Test
    public void shouldDirectToRegistrationPageWhenEmailHasBeenRegistered() throws NoSuchAlgorithmException {
        UserForm userForm = getPasswordInValidUserForm();
        when(registerService.register(any(User.class))).thenReturn(false);
        String actual = registerController.processRegistration(userForm, result, model);
        assertThat(actual, is("registration.html"));
    }

    public UserForm getValidUserForm() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("Jiukun");
        userForm.setLastName("Zhang");
        userForm.setEmail("jkzhang@gmail.com");
        userForm.setPassword("123456");
        userForm.setConfirmPassword("123456");
        return userForm;
    }

    public UserForm getInValidUserForm() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("Jiukun");
        userForm.setLastName("Zhang");
        userForm.setEmail("");
        userForm.setPassword("123456");
        userForm.setConfirmPassword("123456");
        return userForm;
    }

    public UserForm getPasswordInValidUserForm() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("Jiukun");
        userForm.setLastName("Zhang");
        userForm.setEmail("jkzhang@gmail.com");
        userForm.setPassword("123456");
        userForm.setConfirmPassword("654321");
        return userForm;
    }
}