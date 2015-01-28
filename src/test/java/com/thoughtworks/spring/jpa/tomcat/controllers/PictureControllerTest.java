package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.PictureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


/**
 * Created by qnxu on 1/28/15.
 */
public class PictureControllerTest {
    @InjectMocks
    private PictureController pictureController;
    @Mock
    private PictureService pictureService;

    private int pictureId;
    private Map<String, String> pictureInformation;

    @Before
    public void setUp(){
        initMocks(this);
        pictureId = 1;
        pictureInformation = new HashMap<>();
        pictureInformation.put("name", "picture1");
        pictureInformation.put("description","This is a picture");

    }

    @Test
    public void shouldDirectToPicturePage(){
        String pageUrl = pictureController.showPicturePage();
        assertThat(pageUrl, is("picture"));
    }

    @Test
    public void shoudReturnInformationWhenInputPictureId(){
        when(pictureService.getPictureInformation(pictureId)).thenReturn(pictureInformation);

        Map<String, String> expectResult = new HashMap<String, String>(){
            {
                put("name", "picture1");
                put("description", "This is a picture");
            }

        };

        assertThat(pictureInformation, is(expectResult));
    }
}
