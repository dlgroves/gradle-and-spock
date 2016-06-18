package com.groves.douglas.controller;

import com.groves.douglas.exception.AppException;
import com.groves.douglas.model.Model;
import com.groves.douglas.validation.Validator;
import com.groves.douglas.view.TemplateView;
import com.groves.douglas.view.View;

import java.util.List;

/**
 * Implementation of a controller servicing requests to resolve a view with a
 * template obtained from a model and user-defined parameters.
 * Created by Douglas Groves on 16/06/2016.
 */
public class TemplateController implements Controller {

    private Model model;
    private Validator validator;

    public TemplateController(Model model, Validator validator){
        this.model = model;
        this.validator = validator;
    }

    @Override
    public View service(String loc, List<String> param) throws AppException {
        String template = model.readTemplate(loc);
        validator.validate(template, param);
        return new TemplateView(template, param);
    }
}
