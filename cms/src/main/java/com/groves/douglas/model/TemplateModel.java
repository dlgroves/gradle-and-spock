package com.groves.douglas.model;

import com.groves.douglas.calculator.Calculator;
import com.groves.douglas.exception.AppException;
import com.groves.douglas.model.exception.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Properties;

/**
 * Model implementation that resolves a template from a properties file and
 * populates any placeholders numerically for additional formatting by a
 * MessageFormat class.
 * Created by Douglas Groves on 16/06/2016.
 */
public class TemplateModel implements Model {

    @Autowired
    @Qualifier("properties")
    private Properties properties;

    @Autowired
    @Qualifier("calculator")
    private Calculator calculator;

    public TemplateModel(Properties properties, Calculator calculator){
        this.properties = properties;
        this.calculator = calculator;
    }

    @Override
    public String readTemplate(String loc) throws AppException {
        int strIndex = -1;
        String template = properties.getProperty(loc);
        if(template == null){
            throw new TemplateNotFoundException();
        }
        StringBuilder sb = new StringBuilder(template);
        int match;
        while((match = sb.indexOf("{}")) != -1) {
            strIndex = calculator.add(strIndex, 1);
            sb = sb.insert(match + 1, strIndex);
        }
        return sb.toString();
    }
}
