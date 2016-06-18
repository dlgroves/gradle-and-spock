package com.groves.douglas.validation

import com.groves.douglas.config.SpockContextConfiguration
import com.groves.douglas.validation.exception.MalformedTemplateException
import com.groves.douglas.validation.exception.TooFewParametersException
import com.groves.douglas.validation.exception.TooManyParametersException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.*

/**
 * Unit tests for the TemplateValidator class.
 * Created by Douglas Groves on 18/06/2016
 */
@ActiveProfiles("test")
@ContextConfiguration(classes = [SpockContextConfiguration])
class TemplateValidatorTest extends Specification {

    @Autowired
    @Qualifier("realValidator")
    private Validator validator

    @Unroll
    def "validate #template rendered with parameters '#param'"(template, param, expectedValidity){
        expect:
            expectedValidity == validator.validate(template, param)
        where:
            template           |param           |expectedValidity
            'Hello {0}'        |['Bart']        |true
            'Hello {0} and {1}'|['Bart', 'Lisa']|true
            'Hello'            |[]              |true
    }

    @Unroll
    def "invalidate #template rendered with parameters #param with exception #exception if the template #description"(exception, template, param, description){
        when:
            validator.validate(template, param)
        then:
            thrown(exception)
        where:
            exception                 |template            |param            |description
            MalformedTemplateException|'Hello {0}}'        |['Bart']         |'is malformed'
            TooManyParametersException|'Hello {0}'         |['Homer','Marge']|'has too many parameters'
            TooFewParametersException |'Hello {0} and {1}' |['Lisa']         |'has too few parameters'
    }
}
