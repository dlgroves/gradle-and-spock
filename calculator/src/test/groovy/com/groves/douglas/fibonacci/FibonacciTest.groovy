package com.groves.douglas.fibonacci

import com.groves.douglas.exception.InvalidFibonacciNumberException
import spock.lang.*

/**
 * Unit tests for the Fibonacci class.
 * Created by Douglas Groves on 18/06/2016.
 */
class FibonacciTest extends Specification {

    @Unroll
    def "the #ordinal number in the fibonacci sequence is #result"(number, result, ordinal){
        given:
            def fibonacci = new Fibonacci();
        expect:
            fibonacci.fibon(number) == result
        where:
            number|result|ordinal
            1     |1     |'first'
            2     |1     |'second'
            3     |2     |'third'
            4     |3     |'fourth'
            5     |5     |'fifth'
            6     |8     |'sixth'
            12    |144   |'twelfth'
    }
}
