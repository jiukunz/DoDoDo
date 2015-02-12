package com.thoughtworks.spring.jpa.tomcat.services.impl;

import com.thoughtworks.spring.jpa.tomcat.dao.AdminDao;
import com.thoughtworks.spring.jpa.tomcat.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public int getRegisteredUserCount() {

        return adminDao.getRegisteredUserCount();
    }

    @Override
    public int getActiveUserCount() {
        return adminDao.getActiveUserCount();
    }

    @Override
    public int getUploadedPicCount() {
        return 0;
    }
}
