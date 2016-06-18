package com.groves.douglas.view;

import java.util.List;

/**
 * A bean class used to construct a response from a template resolved by user-defined
 * parameters.
 * Created by Douglas Groves on 16/06/2016.
 */
public interface View {

    /**
     * Return a template resolved using the list of parameters used to
     * construct this View instance.
     * @return
     */
    String render();

    /**
     * Return the template used to construct this View instance.
     * @return
     */
    String getTemplate();

    /**
     * Set the template that this View instance will use to
     * construct a response.
     * @param template
     */
    void setTemplate(String template);

    /**
     * Obtain the parameters that will be substituted into the given template.
     * @return
     */
    List<String> getParameters();

    /**
     * Set the parameters that this View instance will substitute into the
     * given template.
     * @param parameters
     */
    void setParameters(List<String> parameters);
}
