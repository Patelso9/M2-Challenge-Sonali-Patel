package com.company.M2ChallengePatelSonali.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class MathOperation {

    @NotNull(message= "Please enter an integer for Operand 1")
    Integer operand1;

    @NotNull(message= "Please enter an integer for Operand 1")
    Integer operand2;

    @NotNull(message= "Please include an operation")
    private String operator;
    private int answer;

    public MathOperation() {
    }

    public MathOperation(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathOperation that = (MathOperation) o;
        return operand1 == that.operand1 && operand2 == that.operand2 && answer == that.answer && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operator, answer);
    }

    @Override
    public String toString() {
        return "MathOperation{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operator='" + operator + '\'' +
                ", answer=" + answer +
                '}';
    }
}
