package com.groves.douglas.model.exception;

import com.groves.douglas.exception.AppException;

/**
 * A template couldn't be resolved from an external resource with the given
 * parameters.
 * Created by Douglas Groves on 17/06/2016.
 */
public class TemplateNotFoundException extends AppException {
    private String message;
    private Throwable cause;

    public TemplateNotFoundException(){
        super();
    }

    public TemplateNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public TemplateNotFoundException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public TemplateNotFoundException(String message, Throwable cause){
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
