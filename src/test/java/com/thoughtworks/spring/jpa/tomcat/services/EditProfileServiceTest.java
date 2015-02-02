package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class EditProfileServiceTest {
    @InjectMocks
    private EditProfileService editProfileService;
    @Mock
    private UserDao userDao;

    private User user;

    @Before
    public void setup(){
        initMocks(this);

    }

    @Test
    public void shouldSaveEditedUserInformation(){
        editProfileService.updateUserInformation(user);
    }
}
