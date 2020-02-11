package com.assignment.todo;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Title"))).andDo( print()).andExpect( status().isOk());
    }

    @Test
    public void returnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/completed")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Title"))).andDo( print()).andExpect( status().isOk());
    }

    @Test
    public void sendAndReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Title"))).andDo( print()).andExpect( status().isOk());
    }

}