package com.thoughtworks.spring.jpa.tomcat.services;


import java.io.InputStream;

public interface FileUploadService {
    String uploadFile(InputStream inputStream);

    void insertPicInfoToDb(String picKey, Long userId);
}
