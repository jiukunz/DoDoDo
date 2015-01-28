package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class RegisterControllerTest {

    @InjectMocks
    RegisterController registerController;

    @Mock
    RegisterService registerService;


}