package com.groves.douglas.view;

import java.text.MessageFormat;
import java.util.List;

/**
 * Implementation of a class that constructs a response from a given
 * template and user parameters.
 * Created by Douglas Groves on 16/06/2016.
 */
public class TemplateView implements View {

    private String template;
    private List<String> parameters;

    public TemplateView(String template, List<String> parameters){
        this.template = template;
        this.parameters = parameters;
    }

    @Override
    public String render() {
        return MessageFormat.format(template, parameters.toArray());
    }

    @Override
    public String getTemplate(){
        return template;
    }

    @Override
    public void setTemplate(String template){
        this.template = template;
    }

    @Override
    public List<String> getParameters(){
        return parameters;
    }

    @Override
    public void setParameters(List<String> parameters){
        this.parameters = parameters;
    }
}
