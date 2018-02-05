package com.roamer.spittr.web.controller;

import com.roamer.spittr.pojo.Spitter;
import com.roamer.spittr.dao.SpitterRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SpitterControllerTest {

    private SpitterRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        //构建Repository
        mockRepository = Mockito.mock(SpitterRepository.class);
    }

    @After
    public void tearDown() throws Exception {
        mockRepository = null;
    }

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //执行请求
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldShowProcessRegistration() throws Exception {
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //执行请求
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));

        //测试mockRepository的save方法是否至少被调用过一次
        //注意参数也要一致！！！
        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }

    @Test
    public void shouldShowSpitterProfile() throws Exception {
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Mockito.when(mockRepository.findByUsername("jbauer")).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //执行请求
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/jbauer"))
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spitter"))
                .andExpect(MockMvcResultMatchers.model().attribute("spitter", saved));
    }
}