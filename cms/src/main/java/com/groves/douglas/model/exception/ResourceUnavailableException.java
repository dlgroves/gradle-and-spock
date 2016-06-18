package com.groves.douglas.model.exception;

import com.groves.douglas.exception.AppException;

/**
 * An external resource couldn't be resolved.
 * Created by Douglas Groves on 17/06/2016.
 */
public class ResourceUnavailableException extends AppException {
    private String message;
    private Throwable cause;

    public ResourceUnavailableException(){
        super();
    }

    public ResourceUnavailableException(String message){
        super(message);
        this.message = message;
    }

    public ResourceUnavailableException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public ResourceUnavailableException(String message, Throwable cause){
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
