package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.commons.Constants;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.EditProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EditProfileControllerTest {
    @InjectMocks
    private EditProfileController editProfileController;
    @Mock
    private EditProfileService editProfileService;

    private HttpSession httpSession;
    private Model model;

    @Before
    public void setUp(){
        initMocks(this);
        httpSession = mock(HttpSession.class);
        model = mock(Model.class);
    }

    @Test
    public void shouldShowEditProfilePage(){
        String pageUrl = editProfileController.showProfilePage(httpSession, model);
        assertThat(pageUrl.equals("profile"), is(true));
    }

    @Test
    public void shouldSaveEditedUserInformation(){
        String userId = "1";
        String firstName = "xu";
        String lastName = "qn";
        when(httpSession.getAttribute(Constants.LOGIN_KEY)).thenReturn(userId);

        String pageUrl = editProfileController.saveEditedProfile(firstName, lastName, httpSession);
        assertThat(pageUrl.equals("home"), is(true));
    }
}
