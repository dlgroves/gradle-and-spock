package com.groves.douglas.config

import com.groves.douglas.calculator.Calculator
import com.groves.douglas.controller.Controller
import com.groves.douglas.controller.TemplateController
import com.groves.douglas.model.Model
import com.groves.douglas.model.TemplateModel
import com.groves.douglas.validation.TemplateValidator
import com.groves.douglas.validation.Validator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Spring context configuration class.
*  Created by Douglas Groves on 16/06/2016.
*/
@Configuration
@Profile("test")
class SpockContextConfiguration {

    static final def model = new ModelDelegate()
    static final def validator = new ValidatorDelegate()
    static def properties
    static def calculator = new CalculatorDelegate()

    @Bean(name = "mockModel")
    static Model mockModelFactory(){
        return model
    }

    @Bean(name = "realModel")
    Model realModelFactory(){
        return new TemplateModel(realModelProperties(), calculator)
    }

    @Bean(name = "mockValidator")
    static Validator mockValidatorFactory(){
        return validator
    }

    @Bean(name = "realValidator")
    Validator realValidatorFactory(){
        return new TemplateValidator()
    }

    @Bean(name = "controller")
    Controller realControllerFactory(){
        return new TemplateController(model, validator)
    }

    @Bean(name = "properties")
    static Properties realModelProperties(){
        if(properties == null){
            properties = new Properties()
            File file = new File('src/test/resources/router.properties')
            file.withInputStream {
                properties.load(it)
            }
        }
        return properties;
    }

    @Bean(name = "calculator")
    static Calculator mockCalculatorFactory(){
        return calculator
    }

    static class ModelDelegate implements Model {
        @Delegate Model delegate
    }

    static class ValidatorDelegate implements Validator {
        @Delegate Validator delegate
    }

    static class ControllerDelegate implements Controller {
        @Delegate Controller delegate
    }

    static class CalculatorDelegate implements Calculator {
        @Delegate Calculator delegate
    }

}
