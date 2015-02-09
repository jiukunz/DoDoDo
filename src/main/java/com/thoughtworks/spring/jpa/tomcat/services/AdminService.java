package com.thoughtworks.spring.jpa.tomcat.services;

public interface AdminService {
    public int getRegisteredUserCount();
    public int getActiveUserCount();
    public int getUploadedPicCount();
}
