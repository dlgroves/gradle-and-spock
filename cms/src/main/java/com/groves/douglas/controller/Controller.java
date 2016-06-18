package com.groves.douglas.controller;

import com.groves.douglas.exception.AppException;
import com.groves.douglas.view.View;

import java.util.List;

/**
 * A controller that services a request comprised of a path and a list of
 * parameters.
 * Created by Douglas Groves on 16/06/2016.
 */
public interface Controller {

    /**
     * Route a location to a model and resolve a view with a template and user-defined
     * parameters.
     * @param loc
     * @param param
     * @return
     * @throws AppException
     */
    View service(String loc, List<String> param) throws AppException;
}
