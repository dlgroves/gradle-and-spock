package com.groves.douglas.calculator

import spock.lang.*

/**
 * Integration tests for the DefaultCalculator class
 * Created by Douglas Groves on 14/06/2016.
 */
class DefaultCalculatorTest extends Specification {

    def "add two numbers together"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.add(x, y) == z
        where:
        x |y |z
        -1|-1|-2
        0 |-1|-1
        -1|0 |-1
        0 |0 |0
        1 |0 |1
        0 |1 |1
        1 |1 |2
    }

    def "subtract two numbers"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.subtract(x, y) == z
        where:
        x |y |z
        -1|-1|0
        -1| 0|-1
         0|-1|1
         0| 0|0
         1| 0|1
         0| 1|-1
         1| 1|0
    }

    def "multiply two numbers together"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.multiply(x, y) == z
        where:
        x |y |z
        -1|-1|1
        -1| 0|-(0.0f)
         0|-1|-(0.0f)
         0| 0|0
         0| 1|0
         1| 0|0
         1| 1|1
         2| 2|4
         2| 3|6
         3| 2|6
    }

    def "divide two numbers"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.divide(x, y) == z
        where:
             x|y|z
            -1|    -1|1
            -1|     0|Double.NEGATIVE_INFINITY
             0|    -1|-(0.0f)
        -(0.0)|-(0.0)|Double.NaN
        -(0.0)|     0|Double.NaN
             0|-(0.0)|Double.NaN
             0|     0|Double.NaN
             0|     1|0
             1|     0|Double.POSITIVE_INFINITY
             1|     1|1
             2|     1|2

    }
}
