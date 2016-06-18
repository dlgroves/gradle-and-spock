package com.groves.douglas.validation;

import com.groves.douglas.exception.AppException;
import com.groves.douglas.validation.exception.MalformedTemplateException;
import com.groves.douglas.validation.exception.TooFewParametersException;
import com.groves.douglas.validation.exception.TooManyParametersException;

import java.util.List;

/**
 * Implements a class used to validate a template against user-defined
 * parameters.
 * Created by Douglas Groves on 17/06/2016.
 */
public class TemplateValidator implements Validator {
    @Override
    public boolean validate(String template, List<String> parameters) throws AppException {
        boolean openExp = false;
        int parameterCount = 0;
        for(char c : template.toCharArray()){
            if(c != '{' && c != '}'){
                continue;
            }
            if(c == '{' && !openExp){
                openExp = true;
            }else if(c == '}' && openExp){
                openExp = false;
                parameterCount++;
            }else{
                throw new MalformedTemplateException();
            }
        }
        if(parameterCount < parameters.size()) {
            throw new TooManyParametersException();
        }else if(parameterCount > parameters.size()){
            throw new TooFewParametersException();
        }else{
            return true;
        }
    }
}
