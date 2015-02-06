package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.PictureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PictureControllerTest {
    @InjectMocks
    private PictureController pictureController;
    @Mock
    private PictureService pictureService;

    private HttpSession httpSession;
    private Model model;
    private Optional<List<Picture>> picListOptional;

    private String pictureId;
    private Map<String, String> pictureInformation;

    private Picture picture;

    @Before
    public void setUp(){
        initMocks(this);
        httpSession = mock(HttpSession.class);
        model = mock(Model.class);

        pictureId = "111111";

        picture = new Picture();
        picture.setCaption("picture1");
    }

    @Test
    public void shouldDirectToPicturePage(){
        List<Picture> picList = mock(List.class);
        String userId = "1";

        when(pictureService.getPicturesByUserId(userId)).thenReturn(picList);
        String pageUrl = pictureController.showPicturePage(httpSession, model);
        assertThat(pageUrl, is("picture"));
    }

    @Test
    public void shoudReturnInformationWhenInputPictureId(){
        when(pictureService.findPicture(pictureId)).thenReturn(picture);
        picture = pictureController.getPictureInformation(pictureId);

        String expectResult = "picture1";

        assertThat(picture.getCaption(), is(expectResult));
    }
}
