package com.groves.douglas.model

import com.groves.douglas.calculator.Calculator
import com.groves.douglas.config.SpockContextConfiguration
import com.groves.douglas.model.exception.TemplateNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.*

/**
 * Unit tests for the TemplateModel class.
 * Created by Douglas Groves on 17/06/2016.
 */
@ActiveProfiles('test')
@ContextConfiguration(classes = [SpockContextConfiguration])
class TemplateModelTest extends Specification {

    @Qualifier('realModel')
    private @Autowired Model model

    @Qualifier('properties')
    private @Autowired Properties properties

    @Qualifier('calculator')
    private @Autowired Calculator calculator

    private Calculator mockCalculator

    def setup(){
        mockCalculator = Mock(Calculator)
        calculator['delegate'] = mockCalculator
    }

    @Unroll
    def "read template '#template' from properties file using key '#key'"(key, template, calcValues){
        when:
            def actualTemplate = model.readTemplate(key)
        then:
            calcValues.size() * mockCalculator.add(_, _) >>> calcValues
        expect:
            actualTemplate == template
        where:
            key   |template                               |calcValues
            'root'|'Hello my name is {0}'                 |[0.0f]
            'time'|'The time sponsored by {0} will be {1}'|[0.0f,1.0f]
    }

    @Unroll
    def "throw '#exception' if '#value' is used"(exception, value){
        when:
            model.readTemplate(value)
        then:
            thrown(exception)
        where:
            exception                   |value
            NullPointerException        |null
            TemplateNotFoundException   |'a missing template'
    }
}
