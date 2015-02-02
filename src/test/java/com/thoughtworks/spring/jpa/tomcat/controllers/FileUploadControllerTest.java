package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.services.FileUploadService;
import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.multipart.MultipartFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FileUploadControllerTest{
    @InjectMocks
    private FileUploadController fileUploadController;
    @Mock
    private FileUploadService fileUploadService;
    @Mock
    private LoginService loginService;
    private MultipartFile file;
    private String key;
    private User user;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        file = mock(MultipartFile.class);
        user = mock(User.class);
        key = "key";
    }
    @Test
    public void shouldReturnKeyWhenKeyNotNull() throws Exception {
        when(fileUploadService.uploadFile(file.getInputStream())).thenReturn(key);
        when(loginService.getLoginUser()).thenReturn(user);
        assertThat(fileUploadController.processUpload(file), is(key));
    }
    @Test
    public void shouldReturnFailedWhenKeyIsNull() throws Exception {
        when(fileUploadService.uploadFile(file.getInputStream())).thenReturn(null);
        when(loginService.getLoginUser()).thenReturn(user);
        assertThat(fileUploadController.processUpload(file), is("failed"));
    }
}