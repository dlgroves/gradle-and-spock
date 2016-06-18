package com.groves.douglas.exception;

/**
 * An invalid term has been specified.
 * Created by Douglas Groves on 18/06/2016.
 */
public class InvalidFibonacciNumberException extends Exception {
    private String message;
    private Throwable cause;

    public InvalidFibonacciNumberException(){
        super();
    }

    public InvalidFibonacciNumberException(String message){
        super(message);
        this.message = message;
    }

    public InvalidFibonacciNumberException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public InvalidFibonacciNumberException(String message, Throwable cause){
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
