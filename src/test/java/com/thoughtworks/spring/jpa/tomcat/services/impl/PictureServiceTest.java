package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.google.common.base.Optional;
import com.thoughtworks.spring.jpa.tomcat.dao.PictureDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Picture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

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
    private List<Picture> pictureList;
    private String pictureId;

    @Before
    public void setUp(){
        initMocks(this);
        pictureId = "111111";
        picture = new Picture();
        picture.setCaption("jiukun");
        optionalPicture = Optional.of(picture);

        pictureList = new ArrayList<>();
        pictureList.add(picture);
    }

    @Test
    public void shouldReturnPictureInformationWhenInputId(){
        when(pictureDao.getPicById(pictureId)).thenReturn(optionalPicture);

        picture = pictureService.findPicture(pictureId);
        String expectCaption = "jiukun";

        assertThat(picture.getCaption(), is(expectCaption));
    }

    @Test
    public void shouldReturnAllUploadedPictures(){
        Optional<List<Picture>> optionalAllPicList = Optional.of(pictureList);

        when(pictureDao.getFirstTenFeaturedPictures()).thenReturn(optionalAllPicList);

        List<Picture> allPictures = pictureService.getAllPictures();
        assertThat(allPictures, is(optionalAllPicList.get()));
    }

    @Test
    public void shouldReturnPicturesOrderByCreatingDate(){
        Optional<List<Picture>> optionalNewPicList = Optional.of(pictureList);

        when(pictureDao.getFirstTenNewPictures()).thenReturn(optionalNewPicList);

        List<Picture> newPictures = pictureService.getNewPictures();
        assertThat(newPictures, is(pictureList));
    }
}
