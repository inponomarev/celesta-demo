package ru.curs.demo.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.SystemCallContext;
import ru.curs.demo.service.DocumentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.curs.demo.TestData.getBrownOrder;
import static ru.curs.demo.TestData.getPinkOrder;

@SpringBootTest
@AutoConfigureMockMvc
class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getReport() throws Exception {
        String string = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/report")
        ).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("{}", string);
    }
}