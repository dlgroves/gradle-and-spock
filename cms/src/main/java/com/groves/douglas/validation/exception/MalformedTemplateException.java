package com.groves.douglas.validation.exception;

import com.groves.douglas.exception.AppException;

/**
 * A resolved template contains unclosed or stray closing brace characters.
 * Created by Douglas Groves on 18/06/2016.
 */
public class MalformedTemplateException extends AppException {
    private String message;
    private Throwable cause;

    public MalformedTemplateException(){
        super();
    }

    public MalformedTemplateException(String message){
        super(message);
        this.message = message;
    }

    public MalformedTemplateException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public MalformedTemplateException(String message, Throwable cause){
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
