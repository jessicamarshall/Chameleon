package org.selophane.elements.impl;

import org.selophane.elements.Button;
import org.openqa.selenium.WebElement;

/**
 * Wraps a label on a html form with some behavior.
 */
public class ButtonImpl extends ElementImpl implements Button {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ButtonImpl(WebElement element) {
        super(element);
    }

//    @Override
//    public String getFor() {
//        return getWrappedElement().getAttribute("for");
//    }
}