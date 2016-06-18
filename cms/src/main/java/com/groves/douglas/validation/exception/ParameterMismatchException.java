package com.groves.douglas.validation.exception;

import com.groves.douglas.exception.AppException;

/**
 * Parameter substitution failed due to a mismatch between the expected number
 * of parameters and the actual number of parameters.
 * Created by Douglas Groves on 17/06/2016.
 */
public class ParameterMismatchException extends AppException {
    private String message;
    private Throwable cause;

    public ParameterMismatchException(){
        super();
    }

    public ParameterMismatchException(String message){
        super(message);
        this.message = message;
    }

    public ParameterMismatchException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public ParameterMismatchException(String message, Throwable cause){
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
