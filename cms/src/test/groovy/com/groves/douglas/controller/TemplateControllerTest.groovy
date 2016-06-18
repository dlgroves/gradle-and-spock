package com.groves.douglas.controller

import com.groves.douglas.config.SpockContextConfiguration
import com.groves.douglas.model.exception.ResourceUnavailableException
import com.groves.douglas.model.exception.TemplateNotFoundException
import com.groves.douglas.validation.exception.TooFewParametersException
import com.groves.douglas.validation.exception.TooManyParametersException
import com.groves.douglas.model.Model
import com.groves.douglas.validation.Validator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.*

/**
 * Unit test class for TemplateController.
 * Created by Douglas Groves on 16/06/2016.
 */
@ActiveProfiles("test")
@ContextConfiguration(classes = [SpockContextConfiguration])
class TemplateControllerTest extends Specification{

    @Autowired
    @Qualifier("controller")
    def Controller controller

    @Autowired
    @Qualifier("mockModel")
    def Model model

    @Autowired
    @Qualifier("mockValidator")
    def Validator testValidator

    def Model mockModel
    def Validator mockValidator

    def setup(){
        mockModel = Mock(Model)
        mockValidator = Mock(Validator)
        model['delegate'] = mockModel
        testValidator['delegate'] = mockValidator
    }

    @Unroll
    def "resolve template '#modelTemplate' from location '#templateLoc' and inject parameters '#parameters' to produce view '#expectedRender'"(templateLoc, parameters, modelTemplate, expectedRender){
        when:
            def view = controller.service(templateLoc, parameters)
        then:
            1 * mockModel.readTemplate(templateLoc) >> modelTemplate
        expect:
            view != null
            view.getTemplate() == modelTemplate
            view.render() == expectedRender
        where:
            templateLoc|      parameters|        modelTemplate|expectedRender
                 'root'|       ['Homer']|          'Hello {0}'|'Hello Homer'
                 'root'| ['Bart','Lisa']|  'Hello {0} and {1}'|'Hello Bart and Lisa'
                 'root'|              []|              'Hello'|'Hello'
    }

    @Unroll
    def "throw '#exception' if mismatched template '#template' and parameters '#parameters' undergo validation"(exception, templateLoc, template, parameters){
        when:
            controller.service(templateLoc, parameters)
        then:
            1 * mockModel.readTemplate(templateLoc) >> template
            1 * mockValidator.validate(template, parameters) >> { throw exception.newInstance() }
            thrown(exception)
        where:
                               exception|  templateLoc|              template|parameters
              TooManyParametersException|       'root'|   'Hello {0} and {1}'|['Maggie']
               TooFewParametersException|       'root'|           'Hello {0}'|['Homer', 'Marge']
    }

    @Unroll
    def "throw '#exception' if template '#templateLoc' #condition"(exception, templateLoc, parameters, condition){
        when:
            controller.service(templateLoc, parameters)
        then:
            1 * mockModel.readTemplate(templateLoc) >> { throw exception.newInstance() }
            thrown(exception)
        where:
                                exception|  templateLoc|                                  parameters|condition
                TemplateNotFoundException|       'root'|['Homer', 'Marge']|'cannot be found'
             ResourceUnavailableException|       'root'|['Homer', 'Marge']|'cannot be accessed'
    }
}
