package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.impl.PictureServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MyPictureControllerTest {
    @InjectMocks
    private MyPictureController myPictureController;
    @Mock
    private PictureServiceImpl pictureService;

    private HttpSession httpSession;
    private ModelMap modelMap;

    private Picture picture;

    @Before
    public void setUp(){
        initMocks(this);
        httpSession = mock(HttpSession.class);
        modelMap = mock(ModelMap.class);

        picture = new Picture();
        picture.setCaption("picture1");
    }

    @Test
    public void shouldDirectToPicturePage(){
        List<Picture> picList = mock(List.class);
        String userId = "1";

        when(pictureService.getUploadedPicListByUserId(userId)).thenReturn(picList);
        String pageUrl = myPictureController.showPicturePage(httpSession, modelMap);
        assertThat(pageUrl, is("myPicture"));
    }

}
