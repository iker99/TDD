package com.example.tdd_demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreeting() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("Hello, World!"));
    }

}