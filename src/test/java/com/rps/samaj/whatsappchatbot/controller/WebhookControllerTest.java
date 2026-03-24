package com.rps.samaj.whatsappchatbot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebhookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hiReturnsHello() throws Exception {
        String json = """
                {
                  "from": "+10000000000",
                  "text": "Hi"
                }
                """;
        mockMvc.perform(post("/webhook").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("Hello"))
                .andExpect(jsonPath("$.to").value("+10000000000"));
    }

    @Test
    void byeReturnsGoodbye() throws Exception {
        String json = """
                {
                  "from": "+10000000001",
                  "text": "Bye"
                }
                """;
        mockMvc.perform(post("/webhook").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("Goodbye"));
    }

    @Test
    void unknownMessageReturnsFallback() throws Exception {
        String json = """
                {
                  "from": "+10000000002",
                  "text": "Maybe later"
                }
                """;
        mockMvc.perform(post("/webhook").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("Sorry, I only understand Hi and Bye for now."));
    }
}
