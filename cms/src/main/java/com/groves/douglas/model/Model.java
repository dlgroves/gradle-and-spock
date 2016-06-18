package com.groves.douglas.model;

import com.groves.douglas.exception.AppException;

/**
 * A model that fetches a template from an external resource
 * using a given key.
 * Created by Douglas Groves on 16/06/2016.
 */
public interface Model {
    /**
     * Fetch a template from an external key-value resource.
     * @param loc
     * @return
     * @throws AppException
     */
    String readTemplate(String loc) throws AppException;
}
