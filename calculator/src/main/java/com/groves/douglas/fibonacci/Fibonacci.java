package com.groves.douglas.fibonacci;

import com.groves.douglas.exception.InvalidFibonacciNumberException;

/**
 * This class calculates a fibonacci number from a given term.
 * Created by Douglas Groves on 18/06/2016.
 */
public class Fibonacci {

    /**
     * Calculate the nth fibonacci sequence number.
     * @param n
     * @return
     * @throws InvalidFibonacciNumberException
     */
    public int fibon(int n) {
        if(n == 0|| n == 1){
            return n;
        }
        return fibon(n - 1) + fibon(n - 2);
    }
}
