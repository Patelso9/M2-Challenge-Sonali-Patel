package com.company.M2ChallengePatelSonali.controller;

import com.company.M2ChallengePatelSonali.models.MathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

@RestController
public class MathConverterController extends MathOperation {

    private static List<MathOperation> mathList = new ArrayList<>();
    private static int mathSolution;
    private static String mathProblem;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathOperation createAdd(@RequestBody @Valid MathOperation mathOperation){

        mathSolution = sum(mathOperation.getOperand1(), mathOperation.getOperand2());
        mathProblem = "Addition";

        mathOperation.setAnswer(mathSolution);
        mathOperation.setOperator(mathProblem);
        mathList.add(mathOperation);

        return mathOperation;
    }


    @PostMapping(value = "/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathOperation createSubtract(@RequestBody @Valid MathOperation mathOperation){

        mathSolution = Math.subtractExact(mathOperation.getOperand1(), mathOperation.getOperand2());
        mathProblem = "Subtraction";

        mathOperation.setAnswer(mathSolution);
        mathOperation.setOperator(mathProblem);
        mathList.add(mathOperation);

        return mathOperation;
    }


    @PostMapping(value = "/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathOperation createMultiply(@RequestBody @Valid MathOperation mathOperation){

        mathSolution = Math.multiplyExact(mathOperation.getOperand1(), mathOperation.getOperand2());
        mathProblem = "Multiply";

        mathOperation.setAnswer(mathSolution);
        mathOperation.setOperator(mathProblem);
        mathList.add(mathOperation);

        return mathOperation;
    }

    @PostMapping(value = "/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathOperation createDivide(@RequestBody @Valid MathOperation mathOperation){

        mathSolution = Math.floorDiv(mathOperation.getOperand1(), mathOperation.getOperand2());
        mathProblem = "Divide";

        mathOperation.setAnswer(mathSolution);
        mathOperation.setOperator(mathProblem);
        mathList.add(mathOperation);

        return mathOperation;
    }



}
