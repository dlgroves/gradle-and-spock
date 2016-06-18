package com.groves.douglas.validation.exception;

/**
 * Parameter substitution failed as the number of expected parameters exceeded
 * the actual number of parameters.
 * Created by Douglas Groves on 17/06/2016.
 */
public class TooFewParametersException extends ParameterMismatchException{
    private String message;
    private Throwable cause;

    public TooFewParametersException(){
        super();
    }

    public TooFewParametersException(String message){
        super(message);
        this.message = message;
    }

    public TooFewParametersException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public TooFewParametersException(String message, Throwable cause){
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
