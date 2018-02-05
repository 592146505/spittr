package com.roamer.spittr.web.controller;

import com.roamer.spittr.web.controller.HomeController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.junit.Assert.*;

public class HomeControllerTest {

    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        homeController = new HomeController();
    }

    @After
    public void tearDown() throws Exception {
        homeController = null;
    }

    @Test
    public void home() throws Exception {
        assertNotNull(homeController);
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/homePage")).andExpect(view().name("home"));
    }
}