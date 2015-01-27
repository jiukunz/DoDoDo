package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.services.RegisterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegisterControllerTest {
    private MockMvc mockMvc;

    @Autowired
    RegisterService registerService;

    @Test
    public void shouldDirectToRegistrationPage() throws Exception {
        mockMvc.perform(get("/register"))
               .andExpect(status().isOk());
    }
}