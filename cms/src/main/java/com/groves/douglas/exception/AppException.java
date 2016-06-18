package com.groves.douglas.exception;

/**
 * Standard CMS exception class.
 * Created by Douglas Groves on 17/06/2016.
 */
public class AppException extends Exception{
    private String message;
    private Throwable cause;

    public AppException(){
        super();
    }

    public AppException(String message){
        super(message);
        this.message = message;
    }

    public AppException(Throwable cause){
        super(cause);
        this.cause = cause;
    }

    public AppException(String message, Throwable cause){
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
