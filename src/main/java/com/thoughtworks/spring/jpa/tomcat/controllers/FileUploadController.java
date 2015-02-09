package com.thoughtworks.spring.jpa.tomcat.controllers;


import com.thoughtworks.spring.jpa.tomcat.services.FileUploadService;
import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    LoginService loginService;

    @RequestMapping(method= RequestMethod.GET)
    public String showPage(){
        return "upload";
    }

    @RequestMapping(method= RequestMethod.POST)
    public @ResponseBody String processUpload(@RequestParam MultipartFile file) throws IOException {
        String key=fileUploadService.uploadFile(file.getInputStream());
        if(key!=null){
            fileUploadService.insertPicInfoToDb(key, loginService.getLoginUser().getId());
            return key;
        }
        return "failed";
    }
}
