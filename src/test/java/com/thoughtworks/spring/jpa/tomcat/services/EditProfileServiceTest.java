package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.impl.EditProfileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EditProfileServiceTest {
    @InjectMocks
    private EditProfileServiceImpl editProfileService;
    @Mock
    private UserDao userDao;

    private User user;
    private Optional<User> userOptional;

    @Before
    public void setup(){
        initMocks(this);
        user = mock(User.class);
    }

    @Test
    public void shouldGetUserById(){
        String userId = "1";
        userOptional = Optional.of(user);
        when(userDao.selectUserById(userId)).thenReturn(userOptional);
        User realUser = editProfileService.getUserById(userId);
        assertThat(realUser, is(user));
    }

    @Test
    public void shouldSaveEditedUserInformation(){
        int updateCount = editProfileService.updateUserInformation(user);
        assertThat(updateCount>=0, is(true));
    }
}
