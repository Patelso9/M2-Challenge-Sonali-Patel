package com.company.M2ChallengePatelSonali.controller;

import com.company.M2ChallengePatelSonali.models.MathOperation;
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

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.sum;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathConverterController.class)
public class MathConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {



    }

//    ADDITION TESTS
    @Test
    public void addOperandSuccessfulResponse() throws Exception {
        MathOperation mathOperation = new MathOperation(3, 2);
        mathOperation.setAnswer(5);
        mathOperation.setOperator("Addition");

        String outputAdd = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .content(outputAdd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputAdd));
    }

    @Test
    public void addOperandReqNonInt442Error() throws Exception {
        Map<String, String> mathOperation = new HashMap<>();
        mathOperation.put("operand1", "6");
        mathOperation.put("operand1", "hotdog");

        String inputAdd = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .content(inputAdd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

//    SUBTRACT TESTS
    @Test
    public void subtractOperandSuccessfulResponse() throws Exception {
        MathOperation mathOperation = new MathOperation(3, 2);
        mathOperation.setAnswer(1);
        mathOperation.setOperator("Subtraction");

        String outputSubtract = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/subtract")
                        .content(outputSubtract)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputSubtract));
    }

    @Test
    public void subtractOperandReqNonInt442Error() throws Exception {
        Map<String, String> mathOperation = new HashMap<>();
        mathOperation.put("operand1", "hotdog");
        mathOperation.put("operand1", "99");

        String inputSubtract = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/subtract")
                        .content(inputSubtract)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


//    MULTIPLY TESTS
    @Test
    public void multiplyOperandSuccessfulResponse() throws Exception {
        MathOperation mathOperation = new MathOperation(3, 2);
        mathOperation.setAnswer(6);
        mathOperation.setOperator("Multiply");

        String outputMultiply = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/multiply")
                        .content(outputMultiply)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputMultiply));
    }

    @Test
    public void multiplyOperandReqNonInt442Error() throws Exception {
        Map<String, String> mathOperation = new HashMap<>();
        mathOperation.put("operand1", "dog is hot");
        mathOperation.put("operand1", "3");

        String inputMultiply = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/multiply")
                        .content(inputMultiply)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

//    DIVIDE TESTS
    @Test
    public void divideOperandSuccessfulResponse() throws Exception {
        MathOperation mathOperation = new MathOperation(8, 2);
        mathOperation.setAnswer(4);
        mathOperation.setOperator("Divide");

        String outputDivide = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(outputDivide)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputDivide));
    }

    @Test
    public void divideOperandReqNonInt442Error() throws Exception {
        Map<String, String> mathOperation = new HashMap<>();
        mathOperation.put("operand1", "6");
        mathOperation.put("operand1", "hotdog");

        String inputDivide = mapper.writeValueAsString(mathOperation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(inputDivide)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


}