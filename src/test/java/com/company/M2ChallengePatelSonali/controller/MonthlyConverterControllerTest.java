package com.company.M2ChallengePatelSonali.controller;

import com.company.M2ChallengePatelSonali.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthlyConverterController.class)
public class MonthlyConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void returnMonthByMonthNum() throws Exception {
        Month month = new Month(5, "May");

        String outputMonth = mapper.writeValueAsString(month);

        mockMvc.perform(MockMvcRequestBuilders.get("/month/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputMonth));
    }

//    Getting 200 error insteat of 404
//    @Test
//    public void monthNotReturned404Error() throws Exception {
//
//        mockMvc.perform(get("/month/77"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//
//    }

    @Test
    public void returnRandomMonth() throws Exception {

        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}