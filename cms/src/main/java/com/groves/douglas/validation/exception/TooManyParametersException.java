package com.groves.douglas.validation.exception;

/**
 * Parameter substitution failed as the actual number of parameters exceeded
 * expectations.
 * Created by Douglas Groves on 17/06/2016.
 */
public class TooManyParametersException extends ParameterMismatchException{
    private String message;
    private Throwable cause;

    public TooManyParametersException(){
        super();
    }

    public TooManyParametersException(String message){
        super(message);
        this.message = message;
    }

    public TooManyParametersException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public TooManyParametersException(String message, Throwable cause){
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
