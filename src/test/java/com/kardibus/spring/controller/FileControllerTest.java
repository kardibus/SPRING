package com.kardibus.spring.controller;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FileControllerTest {

    @Autowired
    private FileController fileController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception{
       assertThat(fileController).isNotNull();
    }

    @Test
    public void createTest() throws Exception{
        this.mockMvc.perform(get("/create")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void deleteTest() throws Exception{
        this.mockMvc.perform(get("/delete")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));
    }
}
