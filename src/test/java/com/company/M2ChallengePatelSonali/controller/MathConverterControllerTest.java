package com.company.M2ChallengePatelSonali.controller;

import com.company.M2ChallengePatelSonali.models.MathOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathConverterController.class)
public class MathConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void mathEquasionWorks() {
        MathOperation mathOperation = new MathOperation();

        String outputJson = mapper.writeValueAsString(mathOperation);

    }
}