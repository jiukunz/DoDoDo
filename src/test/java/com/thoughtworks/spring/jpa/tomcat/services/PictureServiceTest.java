package com.thoughtworks.spring.jpa.tomcat.services;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import com.thoughtworks.spring.jpa.tomcat.services.impl.PictureServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by qnxu on 1/28/15.
 */
public class PictureServiceTest {
    @InjectMocks
    private PictureServiceImpl pictureService;
    @Mock
    private PictureDao pictureDao;

    private Optional<Picture> optionalPicture;
    private Picture picture;
    private String pictureId;

    @Before
    public void setUp(){
        initMocks(this);
        pictureId = "111111";
        picture = new Picture();
        picture.setCaption("jiukun");
        optionalPicture = Optional.of(picture);
    }

    @Test
    public void shouldReturnPictureInformationWhenInputId(){
        when(pictureDao.getPicById(pictureId)).thenReturn(optionalPicture);

        picture = pictureService.findPicture(pictureId);
        String expectCaption = "jiukun";

        assertThat(picture.getCaption(), is(expectCaption));
    }
}
