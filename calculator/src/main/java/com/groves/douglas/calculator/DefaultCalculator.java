package com.groves.douglas.calculator;


/**
 * Default implementation of a calculator performing addition,
 * subtraction, multiplication and division operations.
 * Created by Douglas Groves on 14/06/2016.
 */
public class DefaultCalculator implements Calculator {

    @Override
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    @Override
    public int add(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }

    @Override
    public double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    public double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    @Override
    public double divide(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
}
