package com.groves.douglas.calculator;

/**
 * A simple calculator performing addition, subtraction, multiplication
 * and division operations.
 * Created by Douglas Groves on 14/06/2016.
 */
public interface Calculator {
    /**
     * Add two double numbers together
     * @param firstOperand
     * @param secondOperand
     * @return The result of the operation
     */
    public double add(double firstOperand, double secondOperand);

    /**
     * Add two integer numbers together
     * @param firstOperand
     * @param secondOperand
     * @return
     */
    public int add(int firstOperand, int secondOperand);

    /**
     * Subtract the second number from the first number
     * @param firstOperand
     * @param secondOperand
     * @return The result of the operation
     */
    public double subtract(double firstOperand, double secondOperand);

    /**
     * Multiply two numbers
     * @param firstOperand
     * @param secondOperand
     * @return The result of the operation
     */
    public double multiply(double firstOperand, double secondOperand);

    /**
     * Divide two numbers
     * @param firstOperand
     * @param secondOperand
     * @return The result of the operation
     */
    public double divide(double firstOperand, double secondOperand);
}
