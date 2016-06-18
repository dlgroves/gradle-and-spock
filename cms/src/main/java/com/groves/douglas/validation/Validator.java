package com.groves.douglas.validation;

import com.groves.douglas.exception.AppException;

import java.util.List;

/**
 * Validates a template against declared parameters used to populate
 * placeholders that have been defined in the template.
 * Created by Douglas Groves on 17/06/2016.
 */
public interface Validator {

    /**
     * Validate
     * @param template
     * @param parameters
     * @return
     * @throws AppException
     */
    boolean validate(String template, List<String> parameters) throws AppException;
}
