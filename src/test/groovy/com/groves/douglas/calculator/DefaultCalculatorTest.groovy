package com.groves.douglas.calculator

import spock.lang.*

/**
 * Integration tests for the DefaultCalculator class
 * Created by Douglas Groves on 14/06/2016.
 */
class DefaultCalculatorTest extends Specification {

    @Unroll
    def "#x plus #y equals #z"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.add(x, y) == z
        where:
         x| y|z
        -1|-1|-2
         0|-1|-1
        -1|0 |-1
         0|0 |0
         1|0 |1
         0|1 |1
         1|1 |2
    }

    @Unroll
    def "#x minus #y equals #z"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.subtract(x, y) == z
        where:
         x| y|z
        -1|-1|0
        -1| 0|-1
         0|-1|1
         0| 0|0
         1| 0|1
         0| 1|-1
         1| 1|0
    }

    @Unroll
    def "#x times #y equals #z"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.multiply(x, y) == z
        where:
         x| y|z
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

    @Unroll
    def "#x divided by #y equals #z"(double x, double y, double z){
        given:
        def calculator = new DefaultCalculator()
        expect:
        calculator.divide(x, y) == z
        where:
             x|     y|z
            -1|    -1|1
            -1|     0|Double.NEGATIVE_INFINITY
             0|    -1|-(0.0f)
        -(0.0f)|-(0.0f)|Double.NaN
        -(0.0f)|     0|Double.NaN
             0|-(0.0f)|Double.NaN
             0|     0|Double.NaN
             0|     1|0
             1|     0|Double.POSITIVE_INFINITY
             1|     1|1
             2|     1|2
    }
}
