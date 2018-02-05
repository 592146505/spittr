package com.roamer.spittr.web.controller;

import com.roamer.spittr.pojo.Spittle;
import com.roamer.spittr.dao.SpittleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.web.servlet.view.InternalResourceView;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleControllerTest {

    private SpittleRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        //模拟实现
        mockRepository = mock(SpittleRepository.class);
    }

    @After
    public void tearDown() throws Exception {
        mockRepository = null;
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            expectedSpittles.add(new Spittle("Spittle" + i, new Date()));
        }
        //定义实现行为和返回值
        when(mockRepository.findSpittles(238900L, 50)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/views/spittles.jsp"))
                .build();
        //通过路径请求资源
        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void showSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("hello", new Date());
        //定义实现行为和返回值
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        //通过路径请求资源
        mockMvc.perform(get("/show?spittle_id=12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }
}