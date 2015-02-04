package com.thoughtworks.spring.jpa.tomcat.services;

import com.thoughtworks.spring.jpa.tomcat.entities.Picture;

import java.util.ArrayList;

public interface ShoppingCarService {
    ArrayList<Picture> getPicListByUserId(String userId);
}
